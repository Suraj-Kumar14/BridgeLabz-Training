package com.objectmodeling.AssistedProblems;

public class Employee {
	private String name;
	
	//constructor
	public Employee(String name) {
		this.name=name;
	}
	
	public void showEmployee() {
		System.out.println("Employee: "+name);
	}
}
