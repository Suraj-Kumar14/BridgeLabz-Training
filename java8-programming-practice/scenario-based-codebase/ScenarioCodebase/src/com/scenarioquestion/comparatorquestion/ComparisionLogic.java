package com.scenarioquestion.comparatorquestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ComparisionLogic {

	public static void main(String[] args) {
		
		/*
			 *  1.Compare two students by rank.
	
				2.Compare two employees by salary.
				
				3.Compare two products by price.
				
				4.Compare two strings by length.
				
				5.Compare two bank accounts by balance.
		 */
		
				
		System.out.println("1.Compare two students by rank.");
		System.out.println("---------------------------------");
		List<Student>students=Arrays.asList(new Student("Mohit",27),new Student("Sunny",23),new Student("Monu",30));
		students.stream()
        .sorted(Comparator.comparingInt(Student::getRank))
        .forEach(System.out::println);	

		
		System.out.println("\n2.Compare two employees by salary.");
		System.out.println("--------------------------------------");
		List<Employee>employees=Arrays.asList(new Employee("Mohan",30000),new Employee("Sohan",20000),new Employee("Mohit",32000));
		employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);
		
		
		System.out.println("\n4.Compare two strings by length.");
		System.out.println("-----------------------------------------");
		String s1="Hello";
		String s2="GoodMorning";
		Stream.of(s1,s2).sorted(Comparator.comparing(String::length)).forEach(System.out::println);
		
		
		System.out.println("\n5.Compare two bank accounts by balance.");
		System.out.println("-----------------------------------------------");
		double bal=25000;
		double bal2=20000;
		Stream.of(bal,bal2).sorted(Double::compare).forEach(System.out::println);
		
//		Stream.of(bal, bal2)
//	      .sorted((b1, b2) -> Double.compare(b2, b1))
//	      .forEach(System.out::println);

	}

}
