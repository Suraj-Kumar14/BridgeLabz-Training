package com.fundoo_notes.service.email;

public interface EmailService {

    void sendEmail(
            String to,
            String subject,
            String body
    );

    void sendRegistrationOtp(
            String to,
            String otp
    );

    void sendPasswordResetOtp(
            String to,
            String otp
    );

    void sendPasswordResetSuccess(
            String to
    );

    void sendReminderEmail(
            String to,
            String noteTitle
    );
}