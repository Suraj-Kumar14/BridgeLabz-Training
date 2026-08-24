package com.fundoo_notes.dto.batch;

public class ExcelNoteDTO {

    private String title;
    private String description;

    public ExcelNoteDTO() {
    }

    public ExcelNoteDTO(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public String toString() {
        return "ExcelNoteDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}