package com.fundoo_notes.service.email;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo_notes.entity.EmailOtp;
import com.fundoo_notes.entity.OtpPurpose;
import com.fundoo_notes.repository.EmailOtpRepository;
import com.fundoo_notes.service.exception.InvalidOtpException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailOtpService {

    private final EmailOtpRepository emailOtpRepository;

    private final OtpService otpService;

    @Transactional
    public String generateAndSaveOtp(
            String email,
            OtpPurpose purpose) {

        String otp =
                otpService.generateOtp();

        EmailOtp emailOtp =
                new EmailOtp();

        emailOtp.setEmail(email);

        emailOtp.setOtp(otp);

        emailOtp.setPurpose(purpose);

        emailOtp.setCreatedAt(
                LocalDateTime.now()
        );

        emailOtp.setExpiresAt(
                LocalDateTime.now()
                        .plusMinutes(5)
        );

        emailOtp.setUsed(false);

        emailOtpRepository.save(emailOtp);

        return otp;
    }

    @Transactional
    public void verifyOtp(
            String email,
            String otp,
            OtpPurpose purpose) {

        EmailOtp emailOtp =
                emailOtpRepository
                        .findTopByEmailAndPurposeAndUsedFalseOrderByCreatedAtDesc(
                                email,
                                purpose
                        )
                        .orElseThrow(() ->
                                new InvalidOtpException(
                                        "Invalid OTP"
                                )
                        );

        if (emailOtp.getExpiresAt()
                .isBefore(LocalDateTime.now())) {

            throw new InvalidOtpException(
                    "OTP has expired"
            );
        }

        if (!emailOtp.getOtp().equals(otp)) {

            throw new InvalidOtpException(
                    "Invalid OTP"
            );
        }

        emailOtp.setUsed(true);

        emailOtpRepository.save(emailOtp);
    }
}