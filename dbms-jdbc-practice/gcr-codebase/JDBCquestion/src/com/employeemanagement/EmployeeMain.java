package com.employeemanagement;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeMain {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		EmployeeManagement management=new EmployeeManagement();
		try {
			management.addEmployee(new Employee("sampth","CORE",79999));
			management.addEmployee(new Employee("ravi","HR",54544));
			management.addEmployee(new Employee("surya","MBA",89999));
			management.addEmployee(new Employee("sonu","MCA",35532));
			management.addEmployee(new Employee("alice","Pharma",65699));
			management.addEmployee(new Employee("adam","Hardare",99990));
			
			management.updateEmployeeSalary(1, 88888);
			
			management.deleteEmployee(2);
			management.addEmployee(new Employee("ravi","Electronics",555555));
			management.searchEmployee("ravi");
			
			management.showEmployee();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
