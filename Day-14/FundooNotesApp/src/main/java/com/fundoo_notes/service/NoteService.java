package com.fundoo_notes.service;

import java.util.List;

import com.fundoo_notes.dto.reponse.NoteResponseDTO;
import com.fundoo_notes.dto.request.NoteRequestDTO;

public interface NoteService {

	NoteResponseDTO createNote(NoteRequestDTO request);
	
	List<NoteResponseDTO> getMyNotes();
	
	void deleteNote(Long noteId);
}
