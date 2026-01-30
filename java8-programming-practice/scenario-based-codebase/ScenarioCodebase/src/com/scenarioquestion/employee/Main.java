package com.scenarioquestion.employee;

import java.time.Year;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDataList list=new EmployeeDataList();
		list.addEmployee(new Employee(101,"Mohit",27,"Male","Product Development",2022,25000));
		list.addEmployee(new Employee(102,"Arvind",24,"Male","HR",2020,55000));
		list.addEmployee(new Employee(103,"Monika",30,"Female","Manager",2014,95000));
		list.addEmployee(new Employee(104,"LuckyPal",26,"Male","IT",2024,55000));
		list.addEmployee(new Employee(105,"Miraj",28,"Male","Manager",2013,95000));
		list.addEmployee(new Employee(106,"Sonali",29,"Female","Customer Support",2021,37000));
		list.addEmployee(new Employee(107,"Elisha",23,"Female","Product Development",2024,45000));
		list.addEmployee(new Employee(109,"Titu Tiwari",31,"Male","Pharma",2014,65000));
		list.addEmployee(new Employee(108,"Vikash",30,"Male","Sales",2015,35000));
		list.addEmployee(new Employee(110,"Anjali kumari",25,"Female","IT",2025,75000));
		list.addEmployee(new Employee(111,"Akshay",27,"Male","HR",2018,57000));
		list.addEmployee(new Employee(112,"Avinash",25,"Male","Manager",2020,105000));
		list.addEmployee(new Employee(113,"Deepsikha",27,"Female","Sales",2022,25000));
		
		//1.How many male and female employee are there in the organization?
		System.out.println("\n1.How many male and female employee are there in the organization?");
//		System.out.println(list.employees.stream().collect(Collectors.groupingBy(employee->employee.getGender(),Collectors.counting())));
		System.out.println(list.employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
		
		
		//2.Print the name of all departments in the organization?
		System.out.println("\n2.Name of all departments in the organization?");
		System.out.println(list.employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList()));
		
		
		//3.What is the average age of male and female employees ?
		System.out.println("\n3.The average age of male and female employees ?");
		System.out.println(list.employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getAge))));
		
		
		//4.Get the details of highest paid employee in the organization ?
		System.out.println("\n4.Highest paid employee in the organization ?");
//		Optional<Employee> e = list.employees.stream()
//				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
//		System.out.println(e.get().getSalary());
		
		System.out.println(
				list.employees.stream()
								.sorted(Comparator.comparing(Employee::getSalary).reversed())
								.findFirst().get().getSalary()
				);
		
		
		
		//5.Get the names of all employees who have joined after 2015 ?
		System.out.println("\n5.The names of all employees who have joined after 2015 ?");
		
		list.employees.stream()
						.filter(year->year.getYearOfJoining()>2015)
						.forEach(x->System.out.println(x.getName()));	

		
		
		//6.Count the number of employees in each department ?
		System.out.println("\n6.The number of employees in each department ?");
		
		System.out.println(list.employees.stream()
										.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())));
		
		
		
		//7.What is the average salary of each department ?
		System.out.println("\n7.The average salary of each department ?");
		
		System.out.println(list.employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))));
		
		
		
		//8.Get the details of youngest male employee in the product development department ?
		System.out.println("\n8.Youngest male employee in the product development department ?");
		
		Optional<Employee>e=list.employees.stream()
											.sorted(Comparator.comparing(Employee::getAge))
											.findFirst();
		
		System.out.println(e.get());
		
		
		
		//9.Who has the most working experience in the organization?
		System.out.println("\n9.Who has the most working experience in the organization?");
		
		Optional<Employee>experience=list.employees.stream()
											.sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
		
		int currentYear=Year.now().getValue();
		System.out.println("Name: "+experience.get().getName()+", Year: "+(currentYear-experience.get().getYearOfJoining()));
		
		
		
		//10. How many male and female employees are there in the Sales team?
		System.out.println("\n10.Male and female employees are there in the Sales team?");
		
		System.out.println(list.employees.stream()
											.filter(emp->emp.getDepartment().equalsIgnoreCase("Sales"))
											.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
		
		
		
		//11. What is the average salary of male and female employees ?
		System.out.println("\n11.Average Salary of male and female employee");
		
		System.out.println(list.employees.stream()
											.collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary))));
		
		
		//12.List down the names of all employees in each department ?
		System.out.println("\n---------------------------------------------");
		System.out.println("12.Names of all employees in each department ?");
		
		Map<String,List<String>>empName=list.employees.stream()
													.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));
		empName.forEach((dept,names)->{
			System.out.println("\n"+dept+" Department:");
			names.forEach(name->System.out.println(" -"+name));
		});
		System.out.println("------------------------------------------------");
		
		
		
		//13.What is the average salary and total salary of the whole organization?
		System.out.print("\n13.Employee average salary: ");
		System.out.println(list.employees.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
		System.out.print("Employee total salary: ");
		System.out.println(list.employees.stream().collect(Collectors.summingDouble(Employee::getSalary)));
		
		
		
		//14.Get the employee whose salary are more than 25k.
		System.out.println("\n14.Employee whose salary is more than 25000");
		list.employees.stream().filter(sal->sal.getSalary()>25000).forEach(x->System.out.println(x.getName()));
		
		
		
		//15.Who is the highest paid employee in the organization?
		System.out.print("\n15.Highest paid employee in the organization: ");
		System.out.println(list.employees.stream()
						.sorted(Comparator.comparing(Employee::getSalary)
						.reversed())
						.findFirst().get().getName());
		
		
		
		//16.Who is the second highest paid employee in the organization?
		System.out.println("\n15.Second highest paid employee in the organization: ");
		
		double secondHighestSalary =
		        list.employees.stream()
		            .map(Employee::getSalary)
		            .distinct()
		            .sorted(Comparator.reverseOrder())
		            .skip(1)
		            .findFirst()
		            .orElseThrow(() -> new RuntimeException("Not enough employees"));

						
		List<Employee>secondHighestEmployees=list.employees.stream()
															.filter(sal->sal.getSalary()==secondHighestSalary).collect(Collectors.toList());
		
		secondHighestEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));
		
		
		
		//17.Who is the third highest paid employee in the organization?
		System.out.println("\nThird highest paid employee in the organization?: ");
		double thirdHighestSalary=list.employees.stream()
												.map(Employee::getSalary)
												.distinct()
												.sorted(Comparator.reverseOrder())
												.skip(2)
												.findFirst()
												.orElseThrow(()->new RuntimeException("Not enough employees"));
		
		List<Employee>thirdHighestEmployees=list.employees.stream()
											.filter(sal->sal.getSalary()==thirdHighestSalary)
											.collect(Collectors.toList());
		

		thirdHighestEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));
		
		
		
		//18.Who is the lowest paid employee in the organization?
		System.out.println("\nThe lowest paid employee in the organization?");
		
		double lowestPaid=list.employees.stream()
										.map(Employee::getSalary)
										.distinct()
										.sorted(Comparator.naturalOrder())										
										.findFirst()
										.orElseThrow(()->new RuntimeException("Not enough employees"));
		
		List<Employee>lowestPaidEmployees=list.employees.stream()
														.filter(emp->emp.getSalary()==lowestPaid)
														.collect(Collectors.toList());
										
		lowestPaidEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));	
		
		
		
		//19.Who is the second lowest paid employee in the organization?
System.out.println("\nThe lowest paid employee in the organization?");
		
		double secondLowestPaid=list.employees.stream()
										.map(Employee::getSalary)
										.distinct()
										.sorted(Comparator.naturalOrder())
										.skip(1)
										.findFirst()
										.orElseThrow(()->new RuntimeException("Not enough employees"));
		
		List<Employee>secondLowestPaidEmployees=list.employees.stream()
														.filter(emp->emp.getSalary()==secondLowestPaid)
														.collect(Collectors.toList());
										
		secondLowestPaidEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));	
		
		
		
		//20.Get the first five lowest paid employee in the organization?
		System.out.println("\nFive lowest paid employee:");
		
		List<Employee>fiveLowestPaidEmployees=list.employees.stream()
															.sorted(Comparator.comparingDouble(Employee::getSalary))
															.limit(5)
															.collect(Collectors.toList());
		
		fiveLowestPaidEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));
		
		
		//21.Get the first five highest paid employee in the organization?
System.out.println("\nFive lowest paid employee:");
		
		List<Employee>fiveHighestPaidEmployees=list.employees.stream()
															.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())															
															.limit(5)
															.collect(Collectors.toList());
		
		fiveHighestPaidEmployees.forEach(emp->System.out.println(emp.getName()+": "+emp.getSalary()));
	}

}
