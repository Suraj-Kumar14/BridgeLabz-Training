package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public class FullTimeEmployee extends Employee implements Department{
	private String department;
	
	//constructor
	public FullTimeEmployee(int employeeId,String name,double baseSalary) {
		super(employeeId,name,baseSalary);
	}
	
	@Override
	public double calculateSalary() {
		return baseSalary;
	}
	
	@Override
	public void assignDepartment(String department) {
		this.department=department;
	}
	
	@Override
	public String getDepartmentDetails() {
		return department;
	}
}
