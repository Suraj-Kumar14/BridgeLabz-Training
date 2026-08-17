package com.employee_payroll.service.employee;


import java.util.List;

import org.springframework.data.domain.Page;

import com.employee_payroll.dto.employee.EmployeePatchDTO;
import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;

public interface EmployeeService {

	EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);
	
	Page<EmployeeResponseDTO> getAllEmployees(int page, int size,String sortBy, String direction );
	
	EmployeeResponseDTO getEmployeeById(Long id);
	
	EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO request);
	
	void deleteEmployee(Long id);
	
	List<EmployeeResponseDTO> getEmployeesWithSalaryGreaterThan(Double salary);
	EmployeeResponseDTO patchEmployee(Long id, EmployeePatchDTO dto);
}