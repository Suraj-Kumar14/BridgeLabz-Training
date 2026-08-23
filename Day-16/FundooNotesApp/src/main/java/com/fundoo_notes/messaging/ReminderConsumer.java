package com.fundoo_notes.messaging;

import java.time.LocalDateTime;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fundoo_notes.dto.request.reminder.ReminderMessageDTO;
import com.fundoo_notes.entity.Reminder;
import com.fundoo_notes.entity.ReminderStatus;
import com.fundoo_notes.exception.ReminderNotFoundException;
import com.fundoo_notes.repository.ReminderRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReminderConsumer {

    private final ReminderRepository reminderRepository;


    @JmsListener(destination = "reminder-queue")
    public void receiveMessage(
            ReminderMessageDTO message) {

        System.out.println(
                "Reminder Received"
        );

        System.out.println(
                "Reminder ID: "
                        + message.getReminderId()
        );

        System.out.println(
                "Note ID: "
                        + message.getNoteId()
        );

        System.out.println(
                "User ID: "
                        + message.getUserId()
        );

        System.out.println(
                "Title: "
                        + message.getTitle()
        );


        Reminder reminder =
                reminderRepository
                        .findById(
                                message.getReminderId()
                        )
                        .orElseThrow(() ->
                                new ReminderNotFoundException(
                                        "Reminder not found"
                                )
                        );


        reminder.setStatus(
                ReminderStatus.SENT
        );

        reminder.setSentAt(
                LocalDateTime.now()
        );

        reminderRepository.save(reminder);


        System.out.println(
                "Reminder processed successfully"
        );
    }
}