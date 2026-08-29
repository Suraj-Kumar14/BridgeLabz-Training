package com.fundoo.notes.dto.batch;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExportNoteDTO {

    private Long noteId;
    private Long userId;
    private String title;
    private String description;
    private boolean pinned;
    private boolean archived;
    private boolean trashed;
    private String tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}