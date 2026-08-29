package com.fundoo.notes.service;

import java.util.List;

import com.fundoo.notes.dto.request.NoteRequestDTO;
import com.fundoo.notes.dto.request.UpdateNoteRequestDTO;
import com.fundoo.notes.dto.response.NoteResponseDTO;

public interface NoteService {

	NoteResponseDTO createNote(NoteRequestDTO request, Long userId);

	List<NoteResponseDTO> getMyNotes(Long userId);

	NoteResponseDTO getNoteById(Long noteId, Long userId);

	NoteResponseDTO updateNote(Long noteId, UpdateNoteRequestDTO request, Long userId);

	// Permanent delete - only trashed note
	void deleteNote(Long noteId, Long userId);

	NoteResponseDTO pinNote(Long noteId, Long userId);

	NoteResponseDTO unpinNote(Long noteId, Long userId);

	NoteResponseDTO archiveNote(Long noteId, Long userId);

	NoteResponseDTO unarchiveNote(Long noteId, Long userId);

	NoteResponseDTO trashNote(Long noteId, Long userId);

	NoteResponseDTO restoreNote(Long noteId, Long userId);

	List<NoteResponseDTO> getPinnedNotes(Long userId);

	List<NoteResponseDTO> getArchivedNotes(Long userId);

	List<NoteResponseDTO> getTrashedNotes(Long userId);

	List<NoteResponseDTO> searchNotes(String keyword, Long userId);
}