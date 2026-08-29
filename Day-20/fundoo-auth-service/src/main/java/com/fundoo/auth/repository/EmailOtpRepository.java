package com.fundoo.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundoo.auth.entity.EmailOtp;
import com.fundoo.auth.entity.OtpPurpose;

@Repository
public interface EmailOtpRepository extends JpaRepository<EmailOtp, Long> {

	Optional<EmailOtp> findTopByEmailAndPurposeAndUsedFalseOrderByCreatedAtDesc(String email, OtpPurpose purpose);

	List<EmailOtp> findByEmailAndPurposeAndUsedFalse(String email, OtpPurpose purpose);
}