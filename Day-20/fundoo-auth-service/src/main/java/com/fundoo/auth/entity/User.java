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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    /**
     * Used to invalidate previously issued JWT tokens.
     *
     * Example:
     * User resets password
     *      ↓
     * tokenVersion++
     *      ↓
     * Old JWT becomes invalid
     */
    @Column(nullable = false)
    private Integer tokenVersion = 0;

    /**
     * Indicates whether the user has successfully
     * verified the registration OTP.
     */
    @Column(nullable = false)
    private boolean emailVerified = false;

    /**
     * Controls whether the user is allowed to authenticate.
     *
     * New user:
     * emailVerified = false
     * enabled = false
     *
     * After OTP verification:
     * emailVerified = true
     * enabled = true
     */
    @Column(nullable = false)
    private boolean enabled = false;

    /**
     * Role-based authorization.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    /**
     * Audit information.
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}