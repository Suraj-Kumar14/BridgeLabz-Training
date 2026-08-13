package com.employee_payroll.service.department;

import java.util.List;

import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;

public interface DepartmentService {

	DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);

	DepartmentResponseDTO getDepartmentById(Long departmentId);

	List<DepartmentResponseDTO> getAllDepartments();

	void deleteDepartment(Long departmentId);
}