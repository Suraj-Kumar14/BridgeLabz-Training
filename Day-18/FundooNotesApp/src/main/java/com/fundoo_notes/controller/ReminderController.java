package com.fundoo_notes.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo_notes.dto.request.reminder.ReminderRequestDTO;
import com.fundoo_notes.dto.response.ReminderResponseDTO;
import com.fundoo_notes.service.reminder.ReminderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reminders")
@RequiredArgsConstructor
public class ReminderController {

    private final ReminderService reminderService;


    @PostMapping("/notes/{noteId}")
    public ResponseEntity<ReminderResponseDTO> createReminder(

            @PathVariable Long noteId,

            @Valid
            @RequestBody
            ReminderRequestDTO request) {

        return ResponseEntity.ok(
                reminderService.createReminder(
                        noteId,
                        request
                )
        );
    }


    @GetMapping
    public ResponseEntity<List<ReminderResponseDTO>>
            getMyReminders() {

        return ResponseEntity.ok(
                reminderService.getMyReminders()
        );
    }


    @DeleteMapping("/{reminderId}")
    public ResponseEntity<Void> cancelReminder(

            @PathVariable Long reminderId) {

        reminderService.cancelReminder(reminderId);

        return ResponseEntity
                .noContent()
                .build();
    }
}