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

import com.fundoo_notes.dto.request.tag.TagRequestDTO;
import com.fundoo_notes.dto.response.TagResponseDTO;
import com.fundoo_notes.service.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagController {

	private final TagService tagService;

	@PostMapping
	public ResponseEntity<TagResponseDTO> createTag(@Valid @RequestBody TagRequestDTO request) {

		return ResponseEntity.status(HttpStatus.CREATED).body(tagService.createTag(request));
	}

	@GetMapping
	public ResponseEntity<List<TagResponseDTO>> getAllTags() {

		return ResponseEntity.ok(tagService.getAllTags());
	}

	@GetMapping("/{tagId}")
	public ResponseEntity<TagResponseDTO> getTagById(@PathVariable Long tagId) {

		return ResponseEntity.ok(tagService.getTagById(tagId));
	}

	@DeleteMapping("/{tagId}")
	public ResponseEntity<Void> deleteTag(@PathVariable Long tagId) {

		tagService.deleteTag(tagId);

		return ResponseEntity.noContent().build();
	}
}