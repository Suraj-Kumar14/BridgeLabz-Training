package com.encapsulationandpolymorphism.EmployeeManagementSystem;
import java.util.ArrayList;
import java.util.List;
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee>employees=new ArrayList<>();
		
		Employee e1=new FullTimeEmployee(101,"Alice",50000);
		Employee e2=new PartTimeEmployee(102,"Bob",500,40);
		
		((Department)e1).assignDepartment("HR");
		((Department)e2).assignDepartment("IT");
		
		employees.add(e1);
		employees.add(e2);
		
		for(Employee emp:employees) {
			emp.displayDeatils();
			System.out.println("Department: "+((Department)emp).getDepartmentDetails());
			System.out.println("-------------------------------");
		}
	}

}
