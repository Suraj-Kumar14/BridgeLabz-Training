package com.employee_payroll.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;
import com.employee_payroll.service.employee.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO request) {

		EmployeeResponseDTO response = employeeService.createEmployee(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(@RequestParam(defaultValue = "0")int page,
																		@RequestParam(defaultValue = "10")int size,
																		@RequestParam(defaultValue = "id")String sortBy,
																		@RequestParam(defaultValue = "asc")String direction) {

		return ResponseEntity.ok(employeeService.getAllEmployees(page,size,sortBy,direction));
	}

	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id) {

		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeeRequestDTO request) {

		return ResponseEntity.ok(employeeService.updateEmployee(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

		employeeService.deleteEmployee(id);

		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/salary-greater-than")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesWithSalaryGreaterThan(@RequestParam Double salary) {

	    return ResponseEntity.ok(employeeService.getEmployeesWithSalaryGreaterThan(salary));
	}
}