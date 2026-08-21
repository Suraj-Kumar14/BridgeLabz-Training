package com.fundoo_notes.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.request.note.NotePatchRequestDTO;
import com.fundoo_notes.dto.request.note.NoteRequestDTO;
import com.fundoo_notes.dto.response.NoteResponseDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.Tag;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.NoteNotFoundException;
import com.fundoo_notes.exception.TagNotFoundException;
import com.fundoo_notes.exception.UserNotFoundException;
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

		Note saveNote = noteRepository.save(note);

		return toResponse(saveNote);

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
	public NoteResponseDTO pinNote(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		note.setPinned(true);

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	@Override
	public NoteResponseDTO unpinNote(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Notes note found"));

		note.setPinned(false);

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	@Override
	public NoteResponseDTO archiveNote(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		note.setArchived(true);

		note.setPinned(false);

		Note savedNote = noteRepository.save(note);
		return toResponse(savedNote);
	}

	@Override
	public NoteResponseDTO unarchiveNote(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found exception"));

		note.setArchived(false);

		return toResponse(noteRepository.save(note));
	}

	@Override
	public NoteResponseDTO trashNote(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		note.setTrashed(true);
		note.setPinned(false);
		note.setArchived(false);

		return toResponse(noteRepository.save(note));
	}

	@Override
	public NoteResponseDTO restoreNote(Long noteId) {

		String email = SecurityContextHolder.getContext().getAuthentication().getName();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		note.setPinned(false);
		note.setArchived(false);
		note.setTrashed(false);

		return toResponse(noteRepository.save(note));
	}

	@Override
	public void deleteNotePermanently(Long noteId) {

		String email = getCurrentUser().getEmail();

		Note note = noteRepository.findByNoteIdAndUserEmail(noteId, email)
				.orElseThrow(() -> new NoteNotFoundException("Note not found"));

		if (!note.isTrashed()) {
			throw new RuntimeException("only trashed note deleted permanently");
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
	public NoteResponseDTO getNoteById(Long noteId) {

		User currentUser = getCurrentUser();

		Note note = getUserNote(noteId, currentUser);

		return toResponse(note);
	}

	private Note getUserNote(Long noteId, User currentUser) {

		return noteRepository.findByNoteIdAndUser(noteId, currentUser)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with ID: " + noteId));
	}

	@Override
	public NoteResponseDTO updateNote(Long noteId, NotePatchRequestDTO request) {

		Note note = noteRepository.findById(noteId).orElseThrow(() -> new NoteNotFoundException("Note not found "));

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
	public NoteResponseDTO addTagToNote(Long noteId, Long tagId) {
		
		User currentUser = getCurrentUser();
		
		Note note = getUserNote(noteId, currentUser);
		
		Tag tag = tagRepository.findById(tagId).orElseThrow(()-> new TagNotFoundException("Tag not found with ID: "+tagId));
		
		note.getTags().add(tag);
		
		note.setUpdateAt(LocalDateTime.now());
		
		return toResponse(noteRepository.save(note));
	}

	@Override
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
