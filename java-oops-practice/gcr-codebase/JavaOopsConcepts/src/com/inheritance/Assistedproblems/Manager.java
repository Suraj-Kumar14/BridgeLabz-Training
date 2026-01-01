package com.inheritance.Assistedproblems;

public class Manager extends Employee{
	int teamSize;
	//constructor
	public Manager(String name,String id,double salary,int teamSize) {
		super(name,id,salary);
		this.teamSize=teamSize;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("----Manager Details----");
		super.displayDetails();
		System.out.println("TeamSize: "+teamSize);
		System.out.println();
	}
}
