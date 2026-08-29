package com.fundoo.notes.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNoteRequestDTO {

    private String title;

    private String description;
}