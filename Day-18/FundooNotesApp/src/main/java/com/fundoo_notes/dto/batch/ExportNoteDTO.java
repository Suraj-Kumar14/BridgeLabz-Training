package com.fundoo_notes.dto.batch;

public class ExportNoteDTO {

	private Long noteId;
	private String title;
	private String description;

	public ExportNoteDTO() {
	}

	public ExportNoteDTO(Long noteId, String title, String description) {

		this.noteId = noteId;
		this.title = title;
		this.description = description;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}