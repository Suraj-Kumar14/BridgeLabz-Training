package com.inheritance.HybridInheritance.RestaurantManagemantSystem;

public class Person {
	protected String name;
	protected int id;
	
	//constructor
	public Person(String name,int id) {
		this.name=name;
		this.id=id;
	}
	
	public void displayInfo() {
		System.out.println("Name: "+name+", ID: "+id);
	}
}
