package com.collectors.studentresultgrouping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Student>students=new ArrayList<>();
		
		students.add(new Student("Suraj", "A+"));
		students.add(new Student("Rahul", "A"));
		students.add(new Student("Ankit", "B+"));
		students.add(new Student("Rohit", "A+"));
		students.add(new Student("Amit", "B"));
		students.add(new Student("Vikas", "A"));
		students.add(new Student("Suman", "A+"));
		students.add(new Student("Neha", "B+"));
		students.add(new Student("Pooja", "A"));
		students.add(new Student("Karan", "C"));
		
		students.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.mapping(Student::getName,Collectors.toList()))).forEach((k,v)->System.out.println(k+" - "+v));
	}

}
