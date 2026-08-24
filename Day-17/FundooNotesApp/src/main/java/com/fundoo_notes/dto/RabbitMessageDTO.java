package com.fundoo_notes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMessageDTO {

	private Long noteId;
	private String title;
	private String userEmail;

	@Override
	public String toString() {
		return "NoteMessage{" + "noteId=" + noteId + ", title='" + title + '\'' + ", userEmail='" + userEmail + '\''
				+ '}';
	}
}
