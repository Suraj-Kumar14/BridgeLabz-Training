package com.employee_payroll.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.dto.department.DepartmentRequestDTO;
import com.employee_payroll.dto.department.DepartmentResponseDTO;
import com.employee_payroll.service.department.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {

		this.departmentService = departmentService;
	}

	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO request) {

		DepartmentResponseDTO response = departmentService.createDepartment(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {

		return ResponseEntity.ok(departmentService.getAllDepartments());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long id) {

		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {

		departmentService.deleteDepartment(id);

		return ResponseEntity.noContent().build();
	}
}