package com.fundoo_notes.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fundoo_notes.dto.request.reminder.ReminderMessageDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReminderProducer {

    private static final String REMINDER_QUEUE =
            "reminder-queue";

    private final JmsTemplate jmsTemplate;


    public void sendMessage(
            ReminderMessageDTO message) {

        jmsTemplate.convertAndSend(
                REMINDER_QUEUE,
                message
        );

        System.out.println(
                "Reminder sent to Queue: "
                        + message.getReminderId()
        );
    }
}