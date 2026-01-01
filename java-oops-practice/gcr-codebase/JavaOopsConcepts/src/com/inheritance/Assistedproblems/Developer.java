package com.inheritance.Assistedproblems;

public class Developer extends Employee {
	public String programmingLanguage;
	
	//Constructor
	public Developer(String name,String id, double salary,String programmingLanguage) {
		super(name,id,salary);
		this.programmingLanguage=programmingLanguage;
	}
	
	@Override
	public void displayDetails() {
		System.out.println("-----Developer Details-----");
		super.displayDetails();
		System.out.println("Programming Language: "+programmingLanguage);
		System.out.println();
	}
}
