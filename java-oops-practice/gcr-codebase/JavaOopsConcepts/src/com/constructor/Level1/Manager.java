package com.constructor.Level1;

public class Manager extends Employee {
	
    //constructor
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    // Method accessing public and protected members
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID); // public
        System.out.println("Department: " + department);  // protected
        System.out.println("Salary: " + getSalary());     // private via public method
    }
}
