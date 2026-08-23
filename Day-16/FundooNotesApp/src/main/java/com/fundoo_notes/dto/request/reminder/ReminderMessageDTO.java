package com.fundoo_notes.dto.request.reminder;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReminderMessageDTO implements Serializable {

    private Long reminderId;

    private Long noteId;

    private Long userId;

    private String title;

}