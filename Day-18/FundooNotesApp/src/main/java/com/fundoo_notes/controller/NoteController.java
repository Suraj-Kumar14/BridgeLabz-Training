package com.fundoo_notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo_notes.dto.request.note.NotePatchRequestDTO;
import com.fundoo_notes.dto.request.note.NoteRequestDTO;
import com.fundoo_notes.dto.response.NoteResponseDTO;
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

	@GetMapping("/{noteId}")
	public ResponseEntity<NoteResponseDTO> getNoteById(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.getNoteById(noteId));
	}

	@PatchMapping("/{noteId}")
	public ResponseEntity<NoteResponseDTO> updateNote(@PathVariable Long noteId,
			@RequestBody NotePatchRequestDTO request) {

		return ResponseEntity.ok(noteService.updateNote(noteId, request));
	}

	@PatchMapping("/{noteId}/pin")
	public ResponseEntity<NoteResponseDTO> pinNote(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.pinNote(noteId));
	}

	@PatchMapping("/{noteId}/unpin")
	public ResponseEntity<NoteResponseDTO> unpinNote(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.unpinNote(noteId));
	}

	@PatchMapping("/{noteId}/archive")
	public ResponseEntity<NoteResponseDTO> archiveNote(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.archiveNote(noteId));
	}

	@PatchMapping("/{noteId}/unarchive")
	public ResponseEntity<NoteResponseDTO> unarchiveNote(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.unarchiveNote(noteId));
	}

	@PatchMapping("/{noteId}/trash")
	public ResponseEntity<NoteResponseDTO> trashNote(@PathVariable Long noteId) {

		return ResponseEntity.ok(noteService.trashNote(noteId));
	}

	@PatchMapping("/{noteId}/restore")
	public ResponseEntity<NoteResponseDTO> restoreNote(@PathVariable Long noteId) {
		return ResponseEntity.ok(noteService.restoreNote(noteId));
	}

	@DeleteMapping("/{noteId}")
	public ResponseEntity<Void> deleteNotePermanently(@PathVariable Long noteId) {

		noteService.deleteNotePermanently(noteId);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/pinned")
	public ResponseEntity<List<NoteResponseDTO>> getPinnedNotes() {

		return ResponseEntity.ok(noteService.getPinnedNotes());
	}

	@GetMapping("/archived")
	public ResponseEntity<List<NoteResponseDTO>> getArchivedNotes() {
		return ResponseEntity.ok(noteService.getArchivedNotes());
	}

	@GetMapping("/trashed")
	public ResponseEntity<List<NoteResponseDTO>> getTrashedNotes() {
		return ResponseEntity.ok(noteService.getTrashedNotes());
	}

	@GetMapping("/search")
	public ResponseEntity<List<NoteResponseDTO>> searchNotes(@RequestParam String keyword) {

		return ResponseEntity.ok(noteService.searchNotes(keyword));
	}

	@PutMapping("/{noteId}/tags/{tagId}")
	public ResponseEntity<NoteResponseDTO> addTagToNote(@PathVariable Long noteId, @PathVariable Long tagId) {

		return ResponseEntity.ok(noteService.addTagToNote(noteId, tagId));
	}

	@DeleteMapping("/{noteId}/tags/{tagId}")
	public ResponseEntity<NoteResponseDTO> removeTagFromNote(@PathVariable Long noteId, @PathVariable Long tagId) {

		return ResponseEntity.ok(noteService.removeTagFromNote(noteId, tagId));
	}

}
