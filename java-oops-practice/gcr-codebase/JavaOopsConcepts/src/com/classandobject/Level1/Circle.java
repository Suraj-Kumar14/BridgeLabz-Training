package com.classandobject.Level1;

public class Circle {
	
	//non-static variables
	private double radius;
	
	//Constructor
	public Circle(double radius) {
		this.radius=radius;
	}
	
	//Creating method to calculate and display area of circle
	public void areaCircle() {
		System.out.printf("Area of circle is: %.4f \n",(Math.PI*Math.pow(radius,2)));
		
	}
	
	//Creating method to calculate and print area of circumference
	public void circumferenceCircle() {
		System.out.printf("Circumference of Circle is: %.4f",2*Math.PI*radius);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle=new Circle(2.5);//constructor invoke
		circle.areaCircle();//area method calling
		circle.circumferenceCircle();//circumference method calling
	}

}
