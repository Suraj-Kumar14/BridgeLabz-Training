package com.scenarioquestion.employee_officesystem;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Employee>employees=new ArrayList<>();
		
		employees.add(new Employee("Mohit",27,"Male","Product Development",2022,28000));
		employees.add(new Employee("Arvind",24,"Male","HR",2020,55000));
		employees.add(new Employee("Monika",30,"Female","Manager",2014,95000));
		employees.add(new Employee("LuckyPal",26,"Male","IT",2024,55000));
		employees.add(new Employee("Miraj",28,"Male","Manager",2013,95000));
		employees.add(new Employee("Sonali",29,"Female","Customer Support",2021,37000));
		employees.add(new Employee("Elisha",23,"Female","Product Development",2024,45000));
		employees.add(new Employee("Titu Tiwari",31,"Male","Pharma",2014,65000));
		employees.add(new Employee("Vikash",30,"Male","Sales",2015,29000));
		employees.add(new Employee("Anjali kumari",25,"Female","IT",2025,75000));
		employees.add(new Employee("Akshay",27,"Male","HR",2018,57000));
		employees.add(new Employee("Avinash",25,"Male","Manager",2020,85000));
		employees.add(new Employee("Deepsikha",27,"Female","Sales",2022,25000));
		
		
		System.out.println("\n1.Use lambda to calculate employee bonus (salary > 30,000).");
		System.out.println("-----------------------------------------------------------------------");
		employees.stream()
					.filter(x->x.getSalary()>30000)
					.forEach(x->System.out.println(x.getName()+"--"+"Bonus amount: "+x.getSalary()*.3));
		System.out.println("-----------------------------------------------------------------------");
		
		
		System.out.println("\n2.Sort employees by salary using lambda.");
		System.out.println("-----------------------------------------------------------------------");
//		employees.sort((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()));
//		employees.forEach(System.out::println);
		
		employees.stream()
        .sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary()))
        .forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------");
		
		
		System.out.println("\n3.Use lambda to check promotion eligibility (experience > 3 years).");
		System.out.println("-----------------------------------------------------------------------");
		employees.stream().forEach(x->System.out.println(Year.now().getValue()-x.getYearOfJoining()>3 ? x.getName()+" - eligible for promotion" : x.getName()+" - not eligible for promotion"));
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n4.Use lambda to print employee details.");
		System.out.println("---------------------------------------------------------------------");
		employees.stream().forEach(x->System.out.println(x));
		System.out.println("---------------------------------------------------------------------");
		
		
		System.out.println("\n5.Use lambda to compare two employees’ salaries.");
		System.out.println("---------------------------------------------------------------------");
		Employee e1=employees.get(0);
		Employee e2=employees.get(1);
		employees.stream()
        .sorted((emp1,emp2)->Double.compare(emp1.getSalary(),emp2.getSalary()))
        .limit(2)
        .forEach(System.out::println);
		System.out.println("---------------------------------------------------------------------");
		}

}
