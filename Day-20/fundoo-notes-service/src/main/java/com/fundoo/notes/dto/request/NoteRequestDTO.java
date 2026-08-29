package com.fundoo.notes.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteRequestDTO {

	@NotBlank(message = "Title is required")
	@Size(max = 255, message = "Title must not exceed 255 characters")
	private String title;

	@NotBlank(message = "Description is required")
	private String description;
}