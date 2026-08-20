package com.fundoo_notes.dto.reponse;

import java.time.LocalDateTime;

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
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
}
