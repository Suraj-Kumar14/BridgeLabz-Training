package com.inheritance.Hierarchicalinheritance.SchoolSystemWithDifferentRoles;

public class Person {
	protected String name;
	protected int age;
	protected String role;
	
	//constructor
	public Person(String name,int age,String role) {
		this.name=name;
		this.age=age;
		this.role=role;
	}
	
	//method displayRole()
	public void displayRole() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Role: "+role);
	}
}
