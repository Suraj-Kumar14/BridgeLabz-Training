package com.employee_payroll.dto.employee;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

	private Long id;
	private String name;
	private String email;
	private Long departmentId;
	private String departmentName;
	private Double salary;
	private LocalDateTime joiningDate;
	
}
