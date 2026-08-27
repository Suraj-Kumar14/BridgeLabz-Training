package com.fundoo.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestDTO {

    @NotBlank(message = "Email required")
    @Email
    private String email;

    @NotBlank(message ="Otp required")
    private String otp;

    @NotBlank(message = "newPassword required")
    @Size(min = 8)
    private String newPassword;
}