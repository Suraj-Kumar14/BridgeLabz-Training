package com.PetPal;

public class PetPalApp {
	 public static void main(String[] args) {

	        Pet dog = new Dog("Buddy", 3);
	        Pet cat = new Cat("Luna", 2);
	        Pet bird = new Bird("Kiwi", 1);

	        dog.makeSound();
	        dog.play();
	        dog.feed();
	        dog.showStatus();

	        System.out.println();

	        cat.makeSound();
	        cat.sleep();
	        cat.showStatus();

	        System.out.println();

	        bird.makeSound();
	        bird.play();
	        bird.showStatus();
	    }
}
