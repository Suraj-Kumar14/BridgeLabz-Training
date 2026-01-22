package com.bagnball;

public class Main {

	public static void main(String[] args) {
		Bag bag = new Bag(101,"Red",20);
		
		Ball b1 = new Ball(1001,"Yellow","Medium");
		Ball b2 = new Ball(1002,"Red","Small");
		Ball b3 = new Ball(1003,"Pink","Large");
		
		ToyStorage m = new ToyStorage();
		m.addBag(bag);
		
		m.addBall(b1, 101);
		m.addBall(b2, 101);
		m.addBall(b3, 101);
		
		
		m.displayAllBalls();
		
	
	}
}

