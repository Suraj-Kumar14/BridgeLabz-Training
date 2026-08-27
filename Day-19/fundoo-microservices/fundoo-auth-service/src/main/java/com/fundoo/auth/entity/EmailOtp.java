package com.fundoo.auth.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "email_otps")
@Getter
@Setter
@NoArgsConstructor
public class EmailOtp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Email address for which the OTP was generated.
    @Column(nullable = false)
    private String email;

    /**
     * The OTP value.
     *
     * Note:
     * For a production-grade application, OTP should ideally
     * be hashed instead of storing the plain OTP.
     */
    @Column(nullable = false)
    private String otp;

    /**
     * Purpose of the OTP.
     *
     * REGISTRATION
     * FORGOT_PASSWORD
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OtpPurpose purpose;

    // OTP expiration time.  
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    // Indicates whether this OTP has already been consumed. 
    @Column(nullable = false)
    private boolean used = false;

    //OTP creation time.
    
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}