package com.fundoo.notes.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "noteId",
    "userId",
    "title",
    "description",
    "pinned",
    "archived",
    "trashed",
    "createdAt",
    "updatedAt",
    "tags"
})

@Getter
@Setter
public class NoteResponseDTO {

    private Long noteId;

    private Long userId;

    private String title;

    private String description;

    private boolean pinned;

    private boolean archived;

    private boolean trashed;

    private Set<TagResponseDTO> tags;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}