package com.objectmodeling.AssistedProblems;
import java.util.ArrayList;
public class Department {
	private String deptName;
	private ArrayList<Employee>employees=new ArrayList<>();
	
	public Department(String deptName) {
		this.deptName=deptName;
	}
	
	public void addEmployee(String empName) {
		employees.add(new Employee(empName));
	}
	public void showDepartment() {
		System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.showEmployee();
        }
	}
}
