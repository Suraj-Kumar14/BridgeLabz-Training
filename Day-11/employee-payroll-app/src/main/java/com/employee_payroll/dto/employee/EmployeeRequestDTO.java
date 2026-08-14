package com.employee_payroll.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRequestDTO {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Email is required")
	@Email(message = "Enter a valid Email")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@company\\.com$", message = "Only company email is allowed")
	private String email;

	@NotNull(message = "Department is required")
	@Positive(message = "Department ID must be greater than 0")
	private Long departmentId;

	@NotNull(message = "Salary is required")
	@Positive(message = "Salary must be greater than 0")
	private Double salary;
}