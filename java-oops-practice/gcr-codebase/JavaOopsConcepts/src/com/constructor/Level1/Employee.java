package com.constructor.Level1;

public class Employee {
        // Public variable
        public int employeeID;
        // Protected variable
        protected String department;
        // Private variable
	    private double salary;

	    // Constructor
	    public Employee(int employeeID, String department, double salary) {
	        this.employeeID = employeeID;
	        this.department = department;
	        this.salary = salary;
	    }

	    // Public method to modify salary
	    public void setSalary(double salary) {
	        this.salary = salary;
	    }

	    // Public method to access salary
	    public double getSalary() {
	        return salary;
	    }
}

