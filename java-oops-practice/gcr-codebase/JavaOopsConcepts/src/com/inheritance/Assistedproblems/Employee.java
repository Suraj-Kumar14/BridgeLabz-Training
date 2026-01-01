package com.inheritance.Assistedproblems;

public class Employee {
	public String name;
	public String id;
	public double salary;
	
	//constructor
	public Employee(String name,String id,double salary) {
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	//Method display details;
	public void displayDetails() {
		System.out.println("Name: "+name);
		System.out.println("Id: "+id);
		System.out.println("Salary: "+salary);
	}
}
