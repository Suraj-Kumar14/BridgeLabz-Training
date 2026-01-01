package com.inheritance.Assistedproblems;

public class Intern extends Employee {
	double duration;
	
	//constructor
	public Intern(String name,String id,double salary,double duration) {
		super(name,id,salary);
		this.duration=duration;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("-----Intern Details-----");
		super.displayDetails();
		System.out.println("Duration: "+duration);
		System.out.println();
	}
}
