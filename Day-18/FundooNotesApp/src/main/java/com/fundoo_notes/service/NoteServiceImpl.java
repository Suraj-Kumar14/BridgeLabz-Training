package com.fundoo_notes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.RabbitMessageDTO;
import com.fundoo_notes.dto.request.note.NotePatchRequestDTO;
import com.fundoo_notes.dto.request.note.NoteRequestDTO;
import com.fundoo_notes.dto.response.NoteResponseDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.Tag;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.NoteNotFoundException;
import com.fundoo_notes.exception.NoteNotTrashedException;
import com.fundoo_notes.exception.TagNotFoundException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.messaging.NoteMessageProducer;
import com.fundoo_notes.repository.NoteRepository;
import com.fundoo_notes.repository.TagRepository;
import com.fundoo_notes.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;
	private final UserRepository userRepository;
	private final TagRepository tagRepository;
    private final NoteMessageProducer noteMessageProducer;

	@Override
	public NoteResponseDTO createNote(NoteRequestDTO request) {

		User currentUser = getCurrentUser();

		Note note = new Note();

		note.setTitle(request.getTitle());
		note.setDescription(request.getDescription());

		note.setCreatedAt(LocalDateTime.now());
		note.setUpdateAt(LocalDateTime.now());

		note.setPinned(false);
		note.setArchived(false);
		note.setTrashed(false);

		note.setUser(currentUser);

		Note savedNote = noteRepository.save(note);
		
		RabbitMessageDTO message = new RabbitMessageDTO(
		        savedNote.getNoteId(),
		        savedNote.getTitle(),
		        savedNote.getUser().getEmail()
		);

		noteMessageProducer.sendNoteCreatedMessage(message);

		return toResponse(savedNote);

	}

	@Override
	public List<NoteResponseDTO> getMyNotes() {

		User currentUser = getCurrentUser();

		return noteRepository.findByUserAndTrashedFalse(currentUser).stream().map(this::toResponse).toList();
	}

	private User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();

		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	private NoteResponseDTO toResponse(Note note) {

		return new NoteResponseDTO(note.getNoteId(), note.getTitle(), note.getDescription(), note.getUser().getId(),
				note.getCreatedAt(), note.getUpdateAt(), note.isPinned(), note.isArchived(), note.isTrashed(),
				note.getTags().stream().map(Tag::getName).collect(Collectors.toSet()));

	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO pinNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setPinned(true);

		note.setUpdateAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO unpinNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setPinned(false);

		note.setUpdateAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO archiveNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setArchived(true);
		note.setPinned(false);
		note.setUpdateAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO unarchiveNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setArchived(false);
		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO trashNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setTrashed(true);
		note.setPinned(false);
		note.setArchived(false);
		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO restoreNote(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		note.setPinned(false);
		note.setArchived(false);
		note.setTrashed(false);
		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

	@Override
	@CacheEvict(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public void deleteNotePermanently(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		if (!note.isTrashed()) {
			throw new NoteNotTrashedException("only trashed note deleted permanently");
		}

		noteRepository.delete(note);

	}

	@Override
	public List<NoteResponseDTO> getPinnedNotes() {

		String email = getCurrentUser().getEmail();

		List<Note> notes = noteRepository.findByUserEmailAndPinnedTrueAndTrashedFalse(email);

		return notes.stream().map(this::toResponse).toList();
	}

	@Override
	public List<NoteResponseDTO> getArchivedNotes() {
		String email = getCurrentUser().getEmail();

		List<Note> notes = noteRepository.findByUserEmailAndArchivedTrueAndTrashedFalse(email);

		return notes.stream().map(this::toResponse).toList();
	}

	@Override
	public List<NoteResponseDTO> getTrashedNotes() {

		String email = getCurrentUser().getEmail();

		List<Note> notes = noteRepository.findByUserEmailAndTrashedTrue(email);

		return notes.stream().map(this::toResponse).toList();
	}

	/*
	 * @Override public List<NoteResponseDTO> getAllNormalNotes() {
	 * 
	 * String email = getCurrentUser().getEmail();
	 * 
	 * List<Note>notes =
	 * noteRepository.findByUserEmailAndArchivedFalseAndTrashedFalse(email);
	 * 
	 * return notes.stream().map(this::toResponse).toList(); }
	 */
	@Override
	@Cacheable(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO getNoteById(Long noteId) {

	    System.out.println("🔥 getNoteById() METHOD EXECUTED - DB HIT");
	    
		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		return toResponse(note);
	}

	public Long getCurrentUserId() {

		return getCurrentUser().getId();
	}

	private Note getUserNote(Long noteId, User currentUser) {

		return noteRepository.findByNoteIdAndUser(noteId, currentUser)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with ID: " + noteId));
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO updateNote(Long noteId, NotePatchRequestDTO request) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		if (request.getTitle() != null) {
			note.setTitle(request.getTitle());
		}

		if (request.getDescription() != null) {
			note.setDescription(request.getDescription());
		}

		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

	@Override
	public List<NoteResponseDTO> searchNotes(String keyword) {

		User currentUser = getCurrentUser();

		return noteRepository.searchNotes(currentUser, keyword).stream().map(this::toResponse).toList();
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO addTagToNote(Long noteId, Long tagId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with ID: " + tagId));

		note.getTags().add(tag);
		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

	@Override
	@CachePut(value = "notes", key = "#noteId + '_' + #root.target.getCurrentUserId()")
	public NoteResponseDTO removeTagFromNote(Long noteId, Long tagId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with ID: " + tagId));

		note.getTags().remove(tag);

		note.setUpdateAt(LocalDateTime.now());

		return toResponse(noteRepository.save(note));
	}

}
