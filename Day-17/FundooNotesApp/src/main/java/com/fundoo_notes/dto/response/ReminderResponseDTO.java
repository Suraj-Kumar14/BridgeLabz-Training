package com.fundoo_notes.dto.response;

import java.time.LocalDateTime;

import com.fundoo_notes.entity.ReminderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReminderResponseDTO {

    private Long reminderId;

    private Long noteId;

    private String noteTitle;

    private LocalDateTime reminderTime;

    private ReminderStatus status;

}