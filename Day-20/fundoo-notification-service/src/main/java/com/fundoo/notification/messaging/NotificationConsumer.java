package com.fundoo.notification.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fundoo.notification.config.RabbitMQConfig;
import com.fundoo.notification.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final EmailService emailService;

    @RabbitListener(
            queues = RabbitMQConfig.EMAIL_QUEUE
    )
    public void consumeNotification(
            NotificationMessage notification) {

        log.info(
                "Notification received. Type: {}, Email: {}",
                notification.getType(),
                notification.getEmail()
        );

        try {

            emailService.sendEmail(
                    notification.getEmail(),
                    notification.getSubject(),
                    notification.getBody()
            );

            log.info(
                    "Notification processed successfully. Type: {}",
                    notification.getType()
            );

        } catch (Exception e) {

            log.error(
                    "Failed to process notification for {}",
                    notification.getEmail(),
                    e
            );

            throw e;
        }
    }
}