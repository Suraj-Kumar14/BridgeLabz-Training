package com.fundoo_notes.service;

import java.util.List;

import com.fundoo_notes.dto.request.note.NotePatchRequestDTO;
import com.fundoo_notes.dto.request.note.NoteRequestDTO;
import com.fundoo_notes.dto.response.NoteResponseDTO;

public interface NoteService {

	NoteResponseDTO createNote(NoteRequestDTO request);
	
	List<NoteResponseDTO> getMyNotes();
	
	NoteResponseDTO getNoteById(Long noteId);
	
	NoteResponseDTO updateNote(Long noteId, NotePatchRequestDTO request);
			
	NoteResponseDTO pinNote(Long noteId);
	
	NoteResponseDTO unpinNote(Long noteId);
	
	NoteResponseDTO archiveNote(Long noteId);
	
	NoteResponseDTO unarchiveNote(Long noteId);
	
	NoteResponseDTO trashNote(Long noteId);
	
	NoteResponseDTO restoreNote(Long noteId);
	
	void deleteNotePermanently(Long noteId);
	
	List<NoteResponseDTO> getPinnedNotes();
	
	List<NoteResponseDTO> getArchivedNotes();
	
	List<NoteResponseDTO> getTrashedNotes();
		
    List<NoteResponseDTO> searchNotes(String keyword);

    NoteResponseDTO addTagToNote(Long noteId, Long tagId);

    NoteResponseDTO removeTagFromNote(Long noteId, Long tagId);
}
