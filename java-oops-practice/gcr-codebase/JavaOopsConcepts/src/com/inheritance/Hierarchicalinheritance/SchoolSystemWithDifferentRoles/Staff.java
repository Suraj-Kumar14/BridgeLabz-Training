package com.inheritance.Hierarchicalinheritance.SchoolSystemWithDifferentRoles;

public class Staff extends Person{
	
	//constructor
	public Staff(String name,int age,String role) {
		super(name,age,role);
	}
	
	@Override
	public void displayRole() {
		System.out.println("-----Staff Role-----");
		super.displayRole();
	}
}
