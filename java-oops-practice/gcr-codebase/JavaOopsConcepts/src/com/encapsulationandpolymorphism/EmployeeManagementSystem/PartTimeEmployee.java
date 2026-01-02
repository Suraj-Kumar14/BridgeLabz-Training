package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public class PartTimeEmployee extends Employee implements Department {
	private int hoursWorked;
	private double hourlyRate;
	private String department;
	
	//constructor
	public PartTimeEmployee(int employeeId,String name,double hourlyRate,int hoursWorked) {
		super(employeeId,name,0);
		this.hourlyRate=hourlyRate;
		this.hoursWorked=hoursWorked;
	}
	
	@Override
	public double calculateSalary() {
		return hourlyRate*hoursWorked;
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
