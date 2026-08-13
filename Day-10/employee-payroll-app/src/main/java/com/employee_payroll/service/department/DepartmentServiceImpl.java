package com.employee_payroll.service.department;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_payroll.dao.department.DepartmentDAO;
import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;
import com.employee_payroll.exception.*;
import com.employee_payroll.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentDAO departmentDAO;

	public DepartmentServiceImpl(DepartmentDAO departmentDAO) {

		this.departmentDAO = departmentDAO;
	}

	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {

		if (departmentDAO.existsByName(request.getDepartmentName())) {

			throw new DuplicateDepartmentException("Department already exists: " + request.getDepartmentName());
		}

		Department department = new Department();

		department.setDepartmentName(request.getDepartmentName());

		Department savedDepartment = departmentDAO.save(department);

		return new DepartmentResponseDTO(savedDepartment.getDepartmentId(), savedDepartment.getDepartmentName());
	}

	@Override
	public DepartmentResponseDTO getDepartmentById(Long departmentId) {

		Department department = departmentDAO.findById(departmentId);

		if (department == null) {

			throw new DepartmentNotFoundException("Department not found with id: " + departmentId);
		}

		return new DepartmentResponseDTO(department.getDepartmentId(), department.getDepartmentName());
	}

	@Override
	public List<DepartmentResponseDTO> getAllDepartments() {

		return departmentDAO.findAll().stream().map(
				department -> new DepartmentResponseDTO(department.getDepartmentId(), department.getDepartmentName()))
				.toList();
	}

	@Override
	public void deleteDepartment(Long departmentId) {

		Department department = departmentDAO.findById(departmentId);

		if (department == null) {

			throw new DepartmentNotFoundException("Department not found with id: " + departmentId);
		}

		departmentDAO.deleteById(departmentId);
	}
}