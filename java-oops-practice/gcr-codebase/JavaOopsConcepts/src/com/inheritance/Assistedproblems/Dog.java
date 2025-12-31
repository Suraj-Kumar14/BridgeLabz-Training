package com.inheritance.Assistedproblems;

public class Dog extends Animal{
	
	//Constructor
	public Dog(String name,int age) {
		super(name,age);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Bhow,Bhow");
	}
	
}
