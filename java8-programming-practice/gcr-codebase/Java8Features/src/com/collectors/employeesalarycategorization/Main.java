package com.collectors.employeesalarycategorization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee>employees=new ArrayList<>();
		
		employees.add(new Employee("Suraj","ECE",15000));
		employees.add(new Employee("Allu","IT",23000));
		employees.add(new Employee("Bholu","Manager",14000));
		employees.add(new Employee("Sonu","Sales",18000));
		employees.add(new Employee("Monu","Sales",19000));
		employees.add(new Employee("Suyash","IT",17000));
		employees.add(new Employee("Satyam","Manager",35000));
		employees.add(new Employee("Sujeet","ECE",24000));
		
		employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))).forEach((k,v)->System.out.println(k+" - "+v));
	}

}
