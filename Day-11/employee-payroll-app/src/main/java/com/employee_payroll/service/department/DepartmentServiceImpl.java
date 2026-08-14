package com.employee_payroll.service.department;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;
import com.employee_payroll.exception.*;
import com.employee_payroll.model.Department;
import com.employee_payroll.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository repository;
	
	
	public DepartmentServiceImpl(DepartmentRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public DepartmentResponseDTO createDepartment(DepartmentRequestDTO request) {
		
		if(repository.existsByDepartmentNameIgnoreCase(request.getDepartmentName())) {
			throw new DuplicateDepartmentException("Department already exist with "+request.getDepartmentName());
		}
		
		Department department = toDepartment(request);
		
		Department savDepartment = repository.save(department);
		
		return toResponseDto(savDepartment);
	}

	@Override
	public Page<DepartmentResponseDTO> getAllDepartment(int page, int size) {
		
		Pageable pageable =PageRequest.of(page, size);
		
		return repository.findAll(pageable).map(this::toResponseDto);
	}

	@Override
	public DepartmentResponseDTO getDepartmentById(Long departmentId) {
		Department department = repository.findById(departmentId).orElseThrow(()-> new DepartmentNotFoundException("Department not found with id: "+departmentId));
		
		return toResponseDto(department);
	}

	@Override
	public DepartmentResponseDTO updateDepartment(Long departmentId, DepartmentRequestDTO request) {
		
		Department department = repository.findById(departmentId).orElseThrow(()-> new DepartmentNotFoundException("Department not found with id: "+departmentId));
		
		if(repository.existsByDepartmentNameIgnoreCaseAndDepartmentIdNot(request.getDepartmentName(), departmentId)) {
			throw new DuplicateDepartmentException("Department already exists with name: "+request.getDepartmentName());
		}
		
		department.setDepartmentName(request.getDepartmentName());
		
		Department updatedDepartment= repository.save(department);
		
		return toResponseDto(updatedDepartment);
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		
			Department department = repository.findById(departmentId).orElseThrow(()-> new DepartmentNotFoundException("Department not found with id: "+departmentId));
			
			repository.delete(department);
	}

	private Department toDepartment(DepartmentRequestDTO request) {
		Department department = new Department();
		
		department.setDepartmentName(request.getDepartmentName());
		
		return department;
	}
	
	private DepartmentResponseDTO toResponseDto(Department department) {
		DepartmentResponseDTO dto = new  DepartmentResponseDTO();
		
		dto.setDepartmentId(department.getDepartmentId());
		dto.setDepartmentName(department.getDepartmentName());
		
		return dto;
	}

}