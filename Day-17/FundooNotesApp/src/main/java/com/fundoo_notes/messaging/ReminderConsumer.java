package com.fundoo_notes.messaging;

import java.time.LocalDateTime;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fundoo_notes.dto.request.reminder.ReminderMessageDTO;
import com.fundoo_notes.entity.Reminder;
import com.fundoo_notes.entity.ReminderStatus;
import com.fundoo_notes.exception.ReminderNotFoundException;
import com.fundoo_notes.repository.ReminderRepository;
import com.fundoo_notes.service.email.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReminderConsumer {

    private final ReminderRepository reminderRepository;

    private final EmailService emailService;

    @JmsListener(destination = "reminder-queue")
    public void receiveMessage(
            ReminderMessageDTO message) {

        log.info(
                "Reminder message received. reminderId={}, noteId={}, userId={}, email={}, title={}",
                message.getReminderId(),
                message.getNoteId(),
                message.getUserId(),
                message.getUserEmail(),
                message.getTitle()
        );

        Reminder reminder =
                reminderRepository
                        .findById(
                                message.getReminderId()
                        )
                        .orElseThrow(() ->
                                new ReminderNotFoundException(
                                        "Reminder not found with ID: "
                                                + message.getReminderId()
                                )
                        );

        String subject =
                "Fundoo Notes - Reminder: "
                        + message.getTitle();

        String body =
                "Hello,\n\n"
                + "This is your reminder for the note:\n\n"
                + "Note: "
                + message.getTitle()
                + "\n\n"
                + "Please check your Fundoo Notes application.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        log.info(
                "Sending reminder email to {} for reminderId={}",
                message.getUserEmail(),
                message.getReminderId()
        );

        emailService.sendEmail(
                message.getUserEmail(),
                subject,
                body
        );

        reminder.setStatus(
                ReminderStatus.SENT
        );

        reminder.setSentAt(
                LocalDateTime.now()
        );

        reminderRepository.save(reminder);

        log.info(
                "Reminder processed successfully. reminderId={}, status={}",
                message.getReminderId(),
                ReminderStatus.SENT
        );
    }
}