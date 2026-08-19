package com.fundoo_notes.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message ="Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "Phone number required")
	@Pattern(regexp ="^[6-9]\\d{9}$", message="Enter a valid 10 digit number")
	private String phone;
	
	@NotBlank(message = "Password is required")
	@Size(min=8, message ="Password must contain at least 8 characters")
	private String password;
	
}
