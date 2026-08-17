package com.employee_payroll.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee_payroll.dto.employee.EmployeePatchDTO;
import com.employee_payroll.dto.employee.EmployeeRequestDTO;
import com.employee_payroll.dto.employee.EmployeeResponseDTO;
import com.employee_payroll.service.employee.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Employee Management",
	 description = "APIs for managing employees")

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@Operation(summary = "Create employee",
				description = "Create a new employee record")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "201",
	        description = "Employee created successfully"
	    ),
	    @ApiResponse(
	        responseCode = "400",
	        description = "Invalid employee data"
	    )
	})
	@PostMapping
	public ResponseEntity<EmployeeResponseDTO> createEmployee(@Valid @RequestBody EmployeeRequestDTO request) {

		logger.info("Creating employee with name: {}",request.getName());
		EmployeeResponseDTO response = employeeService.createEmployee(request);

		logger.info("Employee created successfully with id: {}", response.getId());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Operation(
			summary = "Get all employees",
			description = "Retrives a list of all employees")
	@GetMapping
	public ResponseEntity<Page<EmployeeResponseDTO>> getAllEmployees(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String direction) {
		
		logger.info("Fetching all employees");

		return ResponseEntity.ok(employeeService.getAllEmployees(page, size, sortBy, direction));
	}

	@Operation(summary = "Get employee by ID",
			   description = "Retrives employee details using employee ID")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Employee found successfully"
	    ),
	    @ApiResponse(
	        responseCode = "404",
	        description = "Employee not found"
	    )
	})
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable Long id) {

		logger.info("Fetching employee with id: {}", id);
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	@Operation(summary = "Update employee by ID",
				description = "Update employee details using employee ID")
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> updateEmployee(@PathVariable Long id,
			@Valid @RequestBody EmployeeRequestDTO request) {

		logger.info("Updating employee with id: {}",id);
		return ResponseEntity.ok(employeeService.updateEmployee(id, request));
	}

	@Operation(summary = "Delete employee by ID",
				description = "Delete employee details using employee ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

		logger.info("Deleting employee with id: {}", id);
		employeeService.deleteEmployee(id);
		
		logger.info("Employee deleted successfully with id: ", id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<EmployeeResponseDTO> patchEmployee(@PathVariable Long id, @RequestBody EmployeePatchDTO dto){
		
		EmployeeResponseDTO updatedEmployee = employeeService.patchEmployee(id, dto);
		
		return ResponseEntity.ok(updatedEmployee);
	}
	

	@Operation(summary = "Salary greater than given salary",
			   description = "Retrives all salary greater than the given salary")
	@GetMapping("/salary-greater-than")
	public ResponseEntity<List<EmployeeResponseDTO>> getEmployeesWithSalaryGreaterThan(@RequestParam Double salary) {

		return ResponseEntity.ok(employeeService.getEmployeesWithSalaryGreaterThan(salary));
	}
}