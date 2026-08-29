package com.fundoo.auth.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundoo.auth.entity.EmailOtp;
import com.fundoo.auth.entity.OtpPurpose;
import com.fundoo.auth.exception.InvalidOtpException;
import com.fundoo.auth.repository.EmailOtpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailOtpService {

	private final EmailOtpRepository emailOtpRepository;

	private final OtpService otpService;

	@Transactional
	public String generateAndSaveOtp(String email, OtpPurpose purpose) {

		/*
		 * Invalidate previous unused OTPs for the same email and purpose.
		 */
		var previousOtps = emailOtpRepository.findByEmailAndPurposeAndUsedFalse(email, purpose);

		previousOtps.forEach(otp -> otp.setUsed(true));

		emailOtpRepository.saveAll(previousOtps);

		String otp = otpService.generateOtp();

		EmailOtp emailOtp = new EmailOtp();

		emailOtp.setEmail(email);

		emailOtp.setOtp(otp);

		emailOtp.setPurpose(purpose);

		emailOtp.setCreatedAt(LocalDateTime.now());

		emailOtp.setExpiresAt(LocalDateTime.now().plusMinutes(5));

		emailOtp.setUsed(false);

		emailOtpRepository.save(emailOtp);

		return otp;
	}

	@Transactional
	public void verifyOtp(String email, String otp, OtpPurpose purpose) {

		EmailOtp emailOtp = emailOtpRepository.findTopByEmailAndPurposeAndUsedFalseOrderByCreatedAtDesc(email, purpose)
				.orElseThrow(() -> new InvalidOtpException("Invalid OTP"));

		if (emailOtp.getExpiresAt().isBefore(LocalDateTime.now())) {

			throw new InvalidOtpException("OTP has expired");
		}

		if (!emailOtp.getOtp().equals(otp)) {

			throw new InvalidOtpException("Invalid OTP");
		}

		emailOtp.setUsed(true);

		emailOtpRepository.save(emailOtp);
	}
}