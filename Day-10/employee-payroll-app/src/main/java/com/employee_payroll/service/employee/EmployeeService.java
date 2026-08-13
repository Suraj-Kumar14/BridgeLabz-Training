package com.employee_payroll.service.employee;

import java.util.List;

import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;

public interface EmployeeService {

	EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

	EmployeeResponseDTO getEmployeeById(Long id);

	List<EmployeeResponseDTO> getAllEmployees();

	EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request);

	void deleteEmployee(Long id);
}