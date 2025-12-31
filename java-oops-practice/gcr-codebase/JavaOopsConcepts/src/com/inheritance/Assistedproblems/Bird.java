package com.inheritance.Assistedproblems;

public class Bird extends Animal {

	//Constructor
	public Bird(String name,int age) {
		super(name,age);
	}
	
	@Override
	public void makeSound() {
		System.out.println("chirp,chirp");
	}
}
