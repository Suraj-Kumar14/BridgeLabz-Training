package com.fundoo.notes.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo.notes.dto.request.TagRequestDTO;
import com.fundoo.notes.dto.response.TagResponseDTO;
import com.fundoo.notes.service.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;


    @PostMapping
    public ResponseEntity<TagResponseDTO> createTag(
            @Valid @RequestBody TagRequestDTO request) {

        TagResponseDTO response =
                tagService.createTag(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    @GetMapping
    public ResponseEntity<List<TagResponseDTO>> getAllTags() {

        return ResponseEntity.ok(
                tagService.getAllTags()
        );
    }


    @GetMapping("/{tagId}")
    public ResponseEntity<TagResponseDTO> getTagById(
            @PathVariable Long tagId) {

        return ResponseEntity.ok(
                tagService.getTagById(tagId)
        );
    }


    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> deleteTag(
            @PathVariable Long tagId) {

        tagService.deleteTag(tagId);

        return ResponseEntity.noContent().build();
    }


    @PostMapping("/notes/{noteId}/tags/{tagId}")
    public ResponseEntity<TagResponseDTO> addTagToNote(
            @PathVariable Long noteId,
            @PathVariable Long tagId,
            @RequestHeader("X-User-Id") Long userId) {

        TagResponseDTO response =
                tagService.addTagToNote(
                        noteId,
                        tagId,
                        userId
                );

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/notes/{noteId}/tags/{tagId}")
    public ResponseEntity<Void> removeTagFromNote(
            @PathVariable Long noteId,
            @PathVariable Long tagId,
            @RequestHeader("X-User-Id") Long userId) {

        tagService.removeTagFromNote(
                noteId,
                tagId,
                userId
        );

        return ResponseEntity.noContent().build();
    }
}