package com.fundoo_notes.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fundoo_notes.config.RabbitMQConfig;
import com.fundoo_notes.dto.RabbitMessageDTO;

@Service
public class NoteMessageConsumer {


    @RabbitListener(
            queues = RabbitMQConfig.NOTE_QUEUE,
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void consumeNoteCreatedMessage(
            RabbitMessageDTO message) {

        System.out.println(
                "===================================="
        );

        System.out.println(
                "RabbitMQ message received"
        );

        System.out.println(
                "Note ID    : "
                        + message.getNoteId()
        );

        System.out.println(
                "Title      : "
                        + message.getTitle()
        );

        System.out.println(
                "User Email : "
                        + message.getUserEmail()
        );

        System.out.println(
                "Background notification processing..."
        );

        System.out.println(
                "Notification processing completed."
        );

        System.out.println(
                "===================================="
        );
    }
}