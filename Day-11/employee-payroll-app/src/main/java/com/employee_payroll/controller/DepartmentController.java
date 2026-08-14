package com.employee_payroll.controller;


import org.springframework.data.domain.Page;
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
		this.departmentService=departmentService;
	}
	
	@PostMapping
	public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO request){
		DepartmentResponseDTO response= departmentService.createDepartment(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping
	public ResponseEntity<Page<DepartmentResponseDTO>> getAllDepartments(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10")int size){
		return ResponseEntity.ok(departmentService.getAllDepartment(page,size));
	}
	
	@GetMapping("/{departmentId}")
	public ResponseEntity<DepartmentResponseDTO> getDepartmentById(@PathVariable Long departmentId){
		
		return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
	}
	
	@PutMapping("/{departmentId}")
	public ResponseEntity<DepartmentResponseDTO> updateDepartment(@PathVariable Long departmentId,@Valid @RequestBody DepartmentRequestDTO request) {

	    return ResponseEntity.ok(departmentService.updateDepartment(departmentId, request));
	}
	
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long departmentId){
		departmentService.deleteDepartment(departmentId);
		
		return ResponseEntity.noContent().build();
	}
	
}