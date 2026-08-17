package com.employee_payroll.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;
import com.employee_payroll.service.department.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Department Management",
		description = "APIs for managing departments")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Operation(summary = "Create department",
			description = "Creates a new department")
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO request) {
		DepartmentResponseDTO response = departmentService.createDepartment(request);
		logger.info("Creating department: {}", request.getDepartmentName());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(summary =" Get all department",
			description = "Retrives a list of all departments")
	@GetMapping
	public ResponseEntity<Page<DepartmentResponseDTO>> getAllDepartments(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		logger.info("Fetching all departments");
		return ResponseEntity.ok(departmentService.getAllDepartment(page, size));
	}

	@Operation(summary = "Get department by ID",
			description = "Get department details by ID")
	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long departmentId) {
		logger.info("Fetching department with id: {}", departmentId);
		return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
	}

	@PutMapping("/{departmentId}")
	public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable Long departmentId,
			@Valid @RequestBody DepartmentRequestDTO request) {

		logger.info("Updating department with id: {}", departmentId);
		return ResponseEntity.ok(departmentService.updateDepartment(departmentId, request));
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		logger.info("Deleting department with id: {}", departmentId);
		return ResponseEntity.noContent().build();
	}

}