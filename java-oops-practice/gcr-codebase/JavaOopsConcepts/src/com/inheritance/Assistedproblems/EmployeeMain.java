package com.inheritance.Assistedproblems;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee manager=new Manager("Sumit","MI1001",90000.0,8);
		Employee developer=new Developer("Aashish","EI101",35000.0,"Java");
		Employee intern=new Intern("Vikash","II201",15000.0,3.0);
		
		//call display details method
		manager.displayDetails();
		developer.displayDetails();
		intern.displayDetails();
	}

}
