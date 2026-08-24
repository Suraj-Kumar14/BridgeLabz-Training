package com.fundoo_notes.dto.request.reminder;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReminderRequestDTO {

    @NotNull(message = "Reminder time is required")
    @Future(message = "Reminder time must be in future")
    private LocalDateTime reminderTime;

}