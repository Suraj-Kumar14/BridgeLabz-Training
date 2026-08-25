package com.fundoo_notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundoo_notes.entity.EmailOtp;
import com.fundoo_notes.entity.OtpPurpose;

public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {

	Optional<EmailOtp> findTopByEmailAndPurposeAndUsedFalseOrderByCreatedAtDesc(String email, OtpPurpose purpose);

	List<EmailOtp> findByEmailAndPurposeAndUsedFalse(String email, OtpPurpose purpose);
}