package com.fundoo_notes.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "email_otps")
@Getter
@Setter
public class EmailOtp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String otp;

	@Enumerated(EnumType.STRING)
	private OtpPurpose purpose;

	private LocalDateTime expiresAt;

	private boolean used;

	private LocalDateTime createdAt;
}