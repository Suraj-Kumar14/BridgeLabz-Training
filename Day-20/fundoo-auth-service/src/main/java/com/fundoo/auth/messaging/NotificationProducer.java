package com.fundoo.auth.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fundoo.auth.config.RabbitMQConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendRegistrationOtp(
            String email,
            String otp) {

        NotificationMessage message =
                new NotificationMessage(
                        email,
                        "Fundoo Notes - Email Verification OTP",
                        "Hello,\n\n"
                        + "Welcome to Fundoo Notes.\n\n"
                        + "Your email verification OTP is: "
                        + otp
                        + "\n\n"
                        + "This OTP is valid for 5 minutes.\n"
                        + "Please do not share this OTP with anyone.\n\n"
                        + "Regards,\n"
                        + "Fundoo Notes Team",
                        NotificationType.REGISTRATION_OTP
                );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.EMAIL_ROUTING_KEY,
                message
        );
    }


    public void sendPasswordResetOtp(
            String email,
            String otp) {

        NotificationMessage message =
                new NotificationMessage(
                        email,
                        "Fundoo Notes - Password Reset OTP",
                        "Hello,\n\n"
                        + "We received a request to reset your "
                        + "Fundoo Notes password.\n\n"
                        + "Your password reset OTP is: "
                        + otp
                        + "\n\n"
                        + "This OTP is valid for 5 minutes.\n"
                        + "If you did not request this, "
                        + "please ignore this email.\n\n"
                        + "Regards,\n"
                        + "Fundoo Notes Team",
                        NotificationType.PASSWORD_RESET_OTP
                );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.EMAIL_ROUTING_KEY,
                message
        );
    }


    public void sendPasswordResetSuccess(
            String email) {

        NotificationMessage message =
                new NotificationMessage(
                        email,
                        "Fundoo Notes - Password Reset Successful",
                        "Hello,\n\n"
                        + "Your Fundoo Notes password has been "
                        + "reset successfully.\n\n"
                        + "If you did not perform this action, "
                        + "please contact support.\n\n"
                        + "Regards,\n"
                        + "Fundoo Notes Team",
                        NotificationType.PASSWORD_RESET_SUCCESS
                );

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.EMAIL_ROUTING_KEY,
                message
        );
    }
}