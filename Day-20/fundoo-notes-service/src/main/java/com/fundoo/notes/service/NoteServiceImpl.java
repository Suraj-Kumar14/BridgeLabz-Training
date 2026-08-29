package com.fundoo.notes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fundoo.notes.dto.response.TagResponseDTO;
import com.fundoo.notes.dto.request.NoteRequestDTO;
import com.fundoo.notes.dto.request.UpdateNoteRequestDTO;
import com.fundoo.notes.dto.response.NoteResponseDTO;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.exception.NoteNotFoundException;
import com.fundoo.notes.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;

	// CREATE NOTE

	@Override
	@Transactional
	public NoteResponseDTO createNote(NoteRequestDTO request, Long userId) {

		Note note = new Note();

		note.setUserId(userId);
		note.setTitle(request.getTitle());
		note.setDescription(request.getDescription());

		note.setPinned(false);
		note.setArchived(false);
		note.setTrashed(false);

		Note savedNote = noteRepository.save(note);

		return toResponse(savedNote);
	}

	// GET MY NORMAL NOTES

	@Override
	public List<NoteResponseDTO> getMyNotes(Long userId) {

		return noteRepository.findByUserIdAndPinnedFalseAndArchivedFalseAndTrashedFalse(userId).stream()
				.map(this::toResponse).toList();
	}

	// GET NORMAL NOTE BY ID

	@Override
	public NoteResponseDTO getNoteById(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));

		return toResponse(note);
	}

	// UPDATE NORMAL NOTE

	@Override
	@Transactional
	public NoteResponseDTO updateNote(Long noteId, UpdateNoteRequestDTO request, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));
		if (request.getTitle() != null) {
			note.setTitle(request.getTitle());
		}
		if (request.getDescription() != null) {
			note.setDescription(request.getDescription());
		}

		// @PreUpdate automatically updates updatedAt
		return toResponse(note);
	}

	// PERMANENT DELETE
	// ONLY TRASHED NOTE CAN BE DELETED

	@Override
	@Transactional
	public void deleteNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndTrashedTrue(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Only trashed note can be permanently deleted"));

		// Remove note-tag relationships first
		note.getTags().clear();

		noteRepository.save(note);

		// Permanently delete note
		noteRepository.delete(note);
	}

	// PIN NOTE

	@Override
	@Transactional
	public NoteResponseDTO pinNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));

		note.setPinned(true);

		return toResponse(noteRepository.save(note));
	}

	// UNPIN NOTE

	@Override
	@Transactional
	public NoteResponseDTO unpinNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));

		note.setPinned(false);

		return toResponse(noteRepository.save(note));
	}

	// ARCHIVE NOTE

	@Override
	@Transactional
	public NoteResponseDTO archiveNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));

		note.setArchived(true);

		// Archived note should not remain pinned
		note.setPinned(false);

		return toResponse(noteRepository.save(note));
	}

	// UNARCHIVE NOTE

	@Override
	@Transactional
	public NoteResponseDTO unarchiveNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedTrueAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Archived note not found"));

		note.setArchived(false);

		return toResponse(noteRepository.save(note));
	}

	// MOVE TO TRASH

	@Override
	@Transactional
	public NoteResponseDTO trashNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndArchivedFalseAndTrashedFalse(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Normal note not found"));

		note.setTrashed(true);

		// Trashed note should not be pinned
		note.setPinned(false);

		// Trashed note should not be archived
		note.setArchived(false);

		return toResponse(noteRepository.save(note));
	}

	// RESTORE FROM TRASH
	// ONLY TRASHED NOTE CAN BE RESTORED

	@Override
	@Transactional
	public NoteResponseDTO restoreNote(Long noteId, Long userId) {

		Note note = noteRepository.findByNoteIdAndUserIdAndTrashedTrue(noteId, userId)
				.orElseThrow(() -> new NoteNotFoundException("Trashed note not found"));

		note.setTrashed(false);

		return toResponse(noteRepository.save(note));
	}

	// GET PINNED NOTES

	@Override
	public List<NoteResponseDTO> getPinnedNotes(Long userId) {

		return noteRepository.findByUserIdAndPinnedTrueAndArchivedFalseAndTrashedFalse(userId).stream()
				.map(this::toResponse).toList();
	}

	// GET ARCHIVED NOTES

	@Override
	public List<NoteResponseDTO> getArchivedNotes(Long userId) {

		return noteRepository.findByUserIdAndArchivedTrueAndTrashedFalse(userId).stream().map(this::toResponse)
				.toList();
	}

	// GET TRASHED NOTES

	@Override
	public List<NoteResponseDTO> getTrashedNotes(Long userId) {

		return noteRepository.findByUserIdAndTrashedTrue(userId).stream().map(this::toResponse).toList();
	}

	// SEARCH NORMAL NOTES
	@Override
	public List<NoteResponseDTO> searchNotes(String keyword, Long userId) {

		return noteRepository.findByUserIdAndTitleContainingIgnoreCaseAndArchivedFalseAndTrashedFalse(userId, keyword)
				.stream().map(this::toResponse).toList();
	}

	// ENTITY -> RESPONSE DTO
	private NoteResponseDTO toResponse(Note note) {

		NoteResponseDTO response = new NoteResponseDTO();

		response.setNoteId(note.getNoteId());
		response.setUserId(note.getUserId());
		response.setTitle(note.getTitle());
		response.setDescription(note.getDescription());

		response.setPinned(note.isPinned());
		response.setArchived(note.isArchived());
		response.setTrashed(note.isTrashed());

		response.setTags(note.getTags().stream().map(tag -> {
			TagResponseDTO tagResponse = new TagResponseDTO();
			tagResponse.setTagId(tag.getTagId());
			tagResponse.setName(tag.getName());
			return tagResponse;
		}).collect(Collectors.toSet()));

		response.setCreatedAt(note.getCreatedAt());
		response.setUpdatedAt(note.getUpdatedAt());

		return response;
	}
}