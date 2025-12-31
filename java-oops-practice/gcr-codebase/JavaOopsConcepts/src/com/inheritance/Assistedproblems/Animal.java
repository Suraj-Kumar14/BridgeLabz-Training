package com.inheritance.Assistedproblems;

public class Animal {
	public String name;
	public int age;
	
	//constructor
	public Animal(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	//makeSound method
	public void makeSound() {
		System.out.println("Some generic animal sound");
	}
}
