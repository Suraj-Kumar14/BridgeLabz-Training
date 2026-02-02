package com.scenarioquestion.studentschoolsystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Student>students=new ArrayList<>();
		
		students.add(new Student("Suraj",22,1,83));
		students.add(new Student("Priya",17,2,76));
		students.add(new Student("Amit",23,3,91));
		students.add(new Student("Neha",20,5,68));
		students.add(new Student("Ravi",22,4,30));
		students.add(new Student("Anjali",21,6,79));
		students.add(new Student("Karan",16,9,88));
		students.add(new Student("Meena",22,8,72));
		students.add(new Student("Arjun",23,7,95));
		students.add(new Student("Sonia",20,10,27));
		
		
		System.out.println("\n1.Use a lambda expression to print a welcome message for a student.");
		System.out.println("------------------------------------------------------------------------");
		students.stream().forEach(s->System.out.println("Welcome "+s.getName()+" to the Brizlabz training"));
		System.out.println("------------------------------------------------------------------------");
		
		
		System.out.println("\n2.Use lambda to check if a student is pass or fail based on marks.");
		System.out.println("-----------------------------------------------------------------------");
		students.stream().forEach(x->System.out.println(x.getMarks()>33? x.getName()+" is PASS":x.getName()+" is FAIL"));
		System.out.println("-----------------------------------------------------------------------");
		
		
		System.out.println("\n3.Sort students by name using lambda.");
		System.out.println("-----------------------------------------------------------------------");
		students.stream().sorted((a,b)->a.getName().compareToIgnoreCase(b.getName())).forEach(System.out::println);
//		students.sort((a,b)->a.getName().compareTo(b.getName()));
//		students.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");
		
		
		System.out.println("\n4.Sort students by rank using lambda.");
		System.out.println("-----------------------------------------------------------------------");
		students.stream().sorted((a,b)->Integer.compare(a.getRank(),b.getRank())).forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");
		
		
		System.out.println("\n5.Use lambda to display students whose age is above 18.");
		System.out.println("-----------------------------------------------------------------------");
		students.stream().filter(x->x.getAge()>18).forEach(System.out::println);
		System.out.println("-----------------------------------------------------------------------");
	}

}
