package com.classandobject.Level1;

public class Employee {
	
	//non-static variables
	private String name;
	private int id;
	private double salary;
	
	//Constructor
	public Employee(String name,int id,double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	
	//Creating method to display employee details
	public void displayEmployee() {
		System.out.println("Employee Name: "+name);
		System.out.println("Employee id: "+id);
		System.out.println("Employee Salary: "+salary);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee("Rohan",1,50000);//calling constructor
		emp.displayEmployee();//calling the display method
	}

}
