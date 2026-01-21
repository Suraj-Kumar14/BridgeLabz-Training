package com.collections.Map.GroupObjectsproperty;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {		
		
		List<Employee>employees=Arrays.asList(new Employee("Alice","HR"),new Employee("Bob","IT"),new Employee("Carol","HR"));
		
		Map<String,List<Employee>> groupByDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		groupByDept.forEach((dept, empList) -> 
        System.out.println(dept + ": " + empList));
	}

}
