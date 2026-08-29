package com.fundoo.notes.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TagRequestDTO {

	@NotBlank(message = "Tag name is required")
	@Size(max = 100, message = "Tag name must not exceed 100 characters")
	private String name;
}