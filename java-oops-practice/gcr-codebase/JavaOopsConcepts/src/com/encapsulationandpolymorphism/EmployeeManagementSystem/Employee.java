package com.encapsulationandpolymorphism.EmployeeManagementSystem;

public abstract class Employee {
	private int employeeId;
	private String name;
	protected double baseSalary;
		
	//constructor
	public Employee(int employeeId,String name,double baseSalary) {
		this.employeeId=employeeId;
		this.name=name;
		this.baseSalary=baseSalary;
	}
	
	//getter and setter method
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId=employeeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public abstract double calculateSalary();
	
	public void displayDeatils() {
		System.out.println("Employee Id: "+employeeId);
		System.out.println("Name: "+name);
		System.out.println("Salary: "+calculateSalary());
	}
}
