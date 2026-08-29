package com.fundoo.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgetPasswordRequestDTO {

	@NotBlank(message = "Email required")
	@Email(message = "Enter a valid email")
	private String email;
}
