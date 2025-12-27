package com.constructor.Level1;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Manager manager = new Manager(1001, "IT", 60000);

	        manager.displayDetails();

	        // Modify salary using public method
	        manager.setSalary(70000);
	        System.out.println("Updated Salary: " + manager.getSalary());
	}

}
