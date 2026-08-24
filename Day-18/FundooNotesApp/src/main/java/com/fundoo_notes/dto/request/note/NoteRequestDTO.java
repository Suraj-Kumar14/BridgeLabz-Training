package com.fundoo_notes.dto.request.note;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequestDTO {

	@NotBlank(message = "Notes title required")
	private String title;
	
	@NotBlank(message = "Notes description required")
	private String description;
}
