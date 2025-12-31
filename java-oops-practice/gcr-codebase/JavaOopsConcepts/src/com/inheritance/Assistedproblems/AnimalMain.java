package com.inheritance.Assistedproblems;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Animal cat=new Cat("Whiskers",1);
		Animal dog=new Dog("Boxer",2);
		Animal bird=new Bird("Tweety",1);
		
		cat.makeSound();
		dog.makeSound();
		bird.makeSound();
	}

}
