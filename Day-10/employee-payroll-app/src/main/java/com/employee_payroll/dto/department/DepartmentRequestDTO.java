package com.employee_payroll.dto.department;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentRequestDTO {
	
	@NotBlank(message = "Department name required")
	private String departmentName;
}
