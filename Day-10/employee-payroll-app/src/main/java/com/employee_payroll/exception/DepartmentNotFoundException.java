package com.employee_payroll.exception;

public class DepartmentNotFoundException extends RuntimeException {

	public DepartmentNotFoundException(String message) {
		super(message);
	}
}