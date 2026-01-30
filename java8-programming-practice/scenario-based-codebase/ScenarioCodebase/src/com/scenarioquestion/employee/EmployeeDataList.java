package com.scenarioquestion.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataList {

	List<Employee>employees=new ArrayList<>();
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void removeEmployee(int id) {
		for(Employee emp:employees) {
			if(emp.getId()==id) {
				employees.remove(emp);
			}
		}
	}
}
