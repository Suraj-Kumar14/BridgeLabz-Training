package com.inheritance.Assistedproblems;

public class Cat extends Animal{
	
	//constructor
	public Cat(String name,int age) {
		super(name,age);
	}
	
	@Override
	public void makeSound() {
		System.out.println("Meow, Meow");
	}	
	
}
