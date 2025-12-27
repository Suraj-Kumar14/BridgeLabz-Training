package com.constructor.Level1;
import java.util.Scanner;

public class Circle {
	//attributes
	private double radius;
	
	//constructor-1 to calls another constructor
	public Circle(){
	 this(0.0);
	}
	
	//constructor-2 called by another constructor (Constructor chaining)
	public Circle(double radius) {
		this.radius=radius;
	}
	
	//Display radius of circle
	public void displayRadius() {
		System.out.println("Radius of circle: "+radius);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating Scanner object
		Scanner sc=new Scanner(System.in);
		//Take radius from user
		System.out.print("Enter Radius: ");
		double radius=sc.nextDouble();
		
		Circle circle1=new Circle();//invoke default constructor
		Circle circle2=new Circle(radius);//invoke parametrized constructor
		
		//Display radius
		circle1.displayRadius();
		circle2.displayRadius();
		
	}

}
