package com.fundoo_notes.service.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(
            JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(
            String to,
            String subject,
            String body) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        log.info(
                "Email sent successfully to {} with subject '{}'",
                to,
                subject
        );
    }

    @Override
    public void sendRegistrationOtp(
            String to,
            String otp) {

        String subject =
                "Fundoo Notes - Email Verification OTP";

        String body =
                "Hello,\n\n"
                + "Welcome to Fundoo Notes.\n\n"
                + "Your email verification OTP is:\n\n"
                + otp
                + "\n\n"
                + "This OTP is valid for 5 minutes.\n"
                + "Please do not share this OTP with anyone.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        sendEmail(
                to,
                subject,
                body
        );
    }

    @Override
    public void sendPasswordResetOtp(
            String to,
            String otp) {

        String subject =
                "Fundoo Notes - Password Reset OTP";

        String body =
                "Hello,\n\n"
                + "We received a request to reset your Fundoo Notes password.\n\n"
                + "Your password reset OTP is:\n\n"
                + otp
                + "\n\n"
                + "This OTP is valid for 5 minutes.\n"
                + "If you did not request a password reset, please ignore this email.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        sendEmail(
                to,
                subject,
                body
        );
    }

    @Override
    public void sendPasswordResetSuccess(
            String to) {

        String subject =
                "Fundoo Notes - Password Reset Successful";

        String body =
                "Hello,\n\n"
                + "Your Fundoo Notes password has been reset successfully.\n\n"
                + "If you did not perform this action, please contact support immediately.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        sendEmail(
                to,
                subject,
                body
        );
    }

    @Override
    public void sendReminderEmail(
            String to,
            String noteTitle) {

        String subject =
                "Fundoo Notes - Reminder: "
                + noteTitle;

        String body =
                "Hello,\n\n"
                + "This is your reminder for the note:\n\n"
                + noteTitle
                + "\n\n"
                + "Please check your Fundoo Notes application.\n\n"
                + "Regards,\n"
                + "Fundoo Notes Team";

        sendEmail(
                to,
                subject,
                body
        );
    }
}