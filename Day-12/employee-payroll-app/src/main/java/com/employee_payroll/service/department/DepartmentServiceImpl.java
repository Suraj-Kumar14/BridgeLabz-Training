package com.employee_payroll.service.department;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;
import com.employee_payroll.exception.*;
import com.employee_payroll.model.Department;
import com.employee_payroll.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository repository;

	public DepartmentServiceImpl(DepartmentRepository repository) {
		this.repository = repository;
	}
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {

		if (repository.existsByDepartmentNameIgnoreCase(request.getDepartmentName())) {
			throw new DuplicateDepartmentException("Department already exist with " + request.getDepartmentName());
		}

		Department department = toDepartment(request);
		logger.debug("Create Department to repository");
		Department savDepartment = repository.save(department);

		return toResponseDto(savDepartment);
	}

	@Override
	public Page<DepartmentResponseDTO> getAllDepartment(int page, int size) {

		Pageable pageable = PageRequest.of(page, size);

		logger.debug("Get all department from repository");
		return repository.findAll(pageable).map(this::toResponseDto);
	}

	@Override
	public DepartmentResponseDTO getDepartmentById(Long departmentId) {
		Department department = repository.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));

		logger.debug("Get department from repository based on index");
		return toResponseDto(department);
	}

	@Override
	public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO request) {

		Department department = repository.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));

		if (repository.existsByDepartmentNameIgnoreCaseAndDepartmentIdNot(request.getDepartmentName(), departmentId)) {
			throw new DuplicateDepartmentException(
					"Department already exists with name: " + request.getDepartmentName());
		}

		department.setDepartmentName(request.getDepartmentName());

		Department updatedDepartment = repository.save(department);
		logger.debug("Update department to repository");
		return toResponseDto(updatedDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {

		Department department = repository.findById(departmentId)
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + departmentId));

		logger.debug("delete department from repository");
		repository.delete(department);
	}

	private Department toDepartment(DepartmentRequestDTO request) {
		Department department = new Department();

		department.setDepartmentName(request.getDepartmentName());
		logger.debug("Covert dto to entity class");
		return department;
	}

	private DepartmentResponseDTO toResponseDto(Department department) {
		DepartmentResponseDTO dto = new DepartmentResponseDTO();

		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDepartmentName());

		logger.debug("convert entity to response dto");
		return dto;
	}

}