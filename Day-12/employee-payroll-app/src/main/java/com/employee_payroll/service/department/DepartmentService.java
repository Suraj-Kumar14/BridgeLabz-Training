package com.employee_payroll.service.department;


import org.springframework.data.domain.Page;

import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;

public interface DepartmentService {

	DepartmentResponseDTO createDepartment(DepartmentRequestDTO request);
	Page<DepartmentResponseDTO> getAllDepartment(int page, int size);
	DepartmentResponseDTO getDepartmentById(Long departmentId);
	DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO request);
	void deleteDepartment(Long departmentId);
}