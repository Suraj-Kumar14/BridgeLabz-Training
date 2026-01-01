package com.inheritance.Hierarchicalinheritance.SchoolSystemWithDifferentRoles;

public class Teacher extends Person{
	private String subject;
	
	//constructor
	public Teacher(String name,int age,String role,String subject) {
		super(name,age,role);
		this.subject=subject;
	}
	
	@Override
	public void displayRole() {
		System.out.println("-----Teacher Details-----");
		super.displayRole();
		System.out.println("Subject: "+subject);
		System.out.println();
	}
}
