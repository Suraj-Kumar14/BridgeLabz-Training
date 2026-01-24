package com.streams.objectserialization;

import java.io.Serializable;

public class Employee implements Serializable{
	private String name;
	private int id;
	private String department;
	private double salary;
		
	public Employee(String name, int id, String department, double salary) {
		this.name = name;
		this.id = id;
		this.department = department;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", department=" + department + ", salary=" + salary + "]";
	}
	
}
