package com.fundoo_notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo_notes.dto.reponse.NoteResponseDTO;
import com.fundoo_notes.dto.request.NoteRequestDTO;
import com.fundoo_notes.service.NoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notes")
public class NoteController {

	private final NoteService noteService;

	@PostMapping
	public ResponseEntity<NoteResponseDTO> createNote(@Valid @RequestBody NoteRequestDTO request) {

		NoteResponseDTO response = noteService.createNote(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<NoteResponseDTO>> getMyNotes() {

		return ResponseEntity.ok(noteService.getMyNotes());
	}

	@DeleteMapping("/{noteId}")
	public ResponseEntity<Void> deleteNote(@PathVariable Long noteId) {

		noteService.deleteNote(noteId);

		return ResponseEntity.noContent().build();
	}
}
