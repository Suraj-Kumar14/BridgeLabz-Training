package com.fundoo_notes.dto.response;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponseDTO {

    private Long noteId;

    private String title;

    private String description;
    
    private Long userId;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    private boolean pinned;

    private boolean archived;

    private boolean trashed;

    private Set<String> tags;
}