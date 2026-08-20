package com.fundoo_notes.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequestDTO {

	@NotBlank(message = "Reset token required")
	private String token;

	@NotBlank(message = "New password required")
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String newPassword;
}