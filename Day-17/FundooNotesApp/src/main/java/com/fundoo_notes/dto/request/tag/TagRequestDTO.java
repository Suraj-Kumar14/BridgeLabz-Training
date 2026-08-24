package com.fundoo_notes.dto.request.tag;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagRequestDTO {

    @NotBlank(message = "Tag name is required")
    private String name;
}
