package com.fundoo.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

	@NotBlank(message = "Email required")
	private String email;
	
	@NotBlank(message = "Password required")
	@Size(min=8, message= "Password must be at least 8 character")
	private String password;
	
}
