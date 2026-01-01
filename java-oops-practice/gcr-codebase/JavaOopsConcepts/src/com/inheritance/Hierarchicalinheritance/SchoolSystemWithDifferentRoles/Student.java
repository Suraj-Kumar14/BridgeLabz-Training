package com.inheritance.Hierarchicalinheritance.SchoolSystemWithDifferentRoles;

public class Student extends Person {
	private char grade;
	
	//constructor
	public Student(String name,int age,String role,char grade) {
		super(name,age,role);
		this.grade=grade;		
	}
	
	@Override
	public void displayRole() {
		System.out.println("-----Student Details-----");
		super.displayRole();
		System.out.println("Grade: "+grade);
		System.out.println();
	}
}
