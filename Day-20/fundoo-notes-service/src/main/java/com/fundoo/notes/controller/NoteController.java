package com.fundoo.notes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.notes.dto.request.NoteRequestDTO;
import com.fundoo.notes.dto.request.UpdateNoteRequestDTO;
import com.fundoo.notes.dto.response.NoteResponseDTO;
import com.fundoo.notes.service.ExcelExportService;
import com.fundoo.notes.service.NoteService;

import jakarta.validation.Valid;
import jakarta.ws.rs.core.HttpHeaders;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

	private final NoteService noteService;
	private final ExcelExportService excelExportService;


	@PostMapping
	public ResponseEntity<NoteResponseDTO> createNote(

			@RequestHeader("X-User-Id") Long userId,

			@Valid @RequestBody NoteRequestDTO request) {

		NoteResponseDTO response = noteService.createNote(request, userId);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


	@GetMapping
	public ResponseEntity<List<NoteResponseDTO>> getMyNotes(

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.getMyNotes(userId));
	}


	@GetMapping("/{noteId}")
	public ResponseEntity<NoteResponseDTO> getNoteById(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.getNoteById(noteId, userId));
	}


	@PatchMapping("/{noteId}")
	public ResponseEntity<NoteResponseDTO> updateNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId,

			@Valid @RequestBody UpdateNoteRequestDTO request) {

		return ResponseEntity.ok(noteService.updateNote(noteId, request, userId));
	}


	@PatchMapping("/{noteId}/pin")
	public ResponseEntity<NoteResponseDTO> pinNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.pinNote(noteId, userId));
	}


	@PatchMapping("/{noteId}/unpin")
	public ResponseEntity<NoteResponseDTO> unpinNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.unpinNote(noteId, userId));
	}


	@PatchMapping("/{noteId}/archive")
	public ResponseEntity<NoteResponseDTO> archiveNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.archiveNote(noteId, userId));
	}


	@PatchMapping("/{noteId}/unarchive")
	public ResponseEntity<NoteResponseDTO> unarchiveNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.unarchiveNote(noteId, userId));
	}


	@PatchMapping("/{noteId}/trash")
	public ResponseEntity<NoteResponseDTO> trashNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.trashNote(noteId, userId));
	}


	@PatchMapping("/{noteId}/restore")
	public ResponseEntity<NoteResponseDTO> restoreNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.restoreNote(noteId, userId));
	}


	@DeleteMapping("/{noteId}")
	public ResponseEntity<Void> deleteNote(

			@PathVariable Long noteId,

			@RequestHeader("X-User-Id") Long userId) {

		noteService.deleteNote(noteId, userId);

		return ResponseEntity.noContent().build();
	}


	@GetMapping("/pinned")
	public ResponseEntity<List<NoteResponseDTO>> getPinnedNotes(

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.getPinnedNotes(userId));
	}


	@GetMapping("/archived")
	public ResponseEntity<List<NoteResponseDTO>> getArchivedNotes(

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.getArchivedNotes(userId));
	}


	@GetMapping("/trash")
	public ResponseEntity<List<NoteResponseDTO>> getTrashedNotes(

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.getTrashedNotes(userId));
	}


	@GetMapping("/search")
	public ResponseEntity<List<NoteResponseDTO>> searchNotes(

			@RequestParam String keyword,

			@RequestHeader("X-User-Id") Long userId) {

		return ResponseEntity.ok(noteService.searchNotes(keyword, userId));
	}
	
	@GetMapping("/export")
	public ResponseEntity<byte[]> exportNotes(
	        @RequestHeader("X-User-Id") Long userId) throws IOException {

	    byte[] excelFile = excelExportService.exportNotes(userId);

	    return ResponseEntity.ok()
	            .header(
	                    HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment; filename=notes.xlsx"
	            )
	            .header(
	                    HttpHeaders.CONTENT_TYPE,
	                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
	            )
	            .body(excelFile);
	}
}