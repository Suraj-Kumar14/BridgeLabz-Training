package com.fundoo_notes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fundoo_notes.dto.reponse.NoteResponseDTO;
import com.fundoo_notes.dto.request.NoteRequestDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.entity.User;
import com.fundoo_notes.exception.NoteNotFoundException;
import com.fundoo_notes.exception.UserNotFoundException;
import com.fundoo_notes.repository.NoteRepository;
import com.fundoo_notes.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;
	private final UserRepository userRepository;

	@Override
	public NoteResponseDTO createNote(NoteRequestDTO request) {
		
		User currentUser = getCurrentUser();
		
		Note note = new Note();
		
		note.setTitle(request.getTitle());
		note.setDescription(request.getDescription());
		
		note.setCreatedAt(LocalDateTime.now());
		note.setUpdateAt(LocalDateTime.now());
		
		note.setUser(currentUser);
		
		Note saveNote = noteRepository.save(note);
		
		return toResponse(saveNote);

	}

	@Override
	public List<NoteResponseDTO> getMyNotes() {
		
		User currentUser = getCurrentUser();
		
		List<Note> notes = noteRepository.findByUser(currentUser);
		
		return notes.stream().map(this::toResponse).toList();
	}

	@Override
	public void deleteNote(Long noteId) {

		User currentUser = getCurrentUser();
		
		Note note = noteRepository.findByNoteIdAndUser(noteId, currentUser).orElseThrow(() -> new NoteNotFoundException("Note note found with note ID: "+noteId));

		noteRepository.delete(note);
	}

	private User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();

		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found"));
	}

	private NoteResponseDTO toResponse(Note note) {

		return new NoteResponseDTO(note.getNoteId(), note.getTitle(), note.getDescription(), note.getCreatedAt(),
				note.getUpdateAt());

	}

}
