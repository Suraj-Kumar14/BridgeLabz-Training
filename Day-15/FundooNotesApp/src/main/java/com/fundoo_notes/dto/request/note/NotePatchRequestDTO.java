package com.fundoo_notes.dto.request.note;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotePatchRequestDTO {

	private String title;
	private String description;
}
