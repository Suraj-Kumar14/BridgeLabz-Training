package com.inheritance.Assistedproblems;

public class Vehicle {
	public int maxSpeed;
	public String fuelType;
	
	//constructor
	public Vehicle(int maxSpeed,String fuelType) {
		this.maxSpeed=maxSpeed;
		this.fuelType=fuelType;
	}
	
	//Method to display vehicle info
	public void displayInfo() {
		System.out.println("Maximum Speed: "+maxSpeed);
		System.out.println("Fuel Type: "+fuelType);
	}
}
