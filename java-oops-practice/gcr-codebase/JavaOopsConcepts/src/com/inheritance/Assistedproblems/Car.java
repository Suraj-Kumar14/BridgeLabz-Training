package com.inheritance.Assistedproblems;

public class Car extends Vehicle{
	public int seatCapacity;
	
	//constructor
	public Car(int maxSpeed,String fuelType,int seatCapacity) {
		super(maxSpeed,fuelType);
		this.seatCapacity=seatCapacity;
	}
		
	@Override
	public void displayInfo() {
		System.out.println();
		System.out.println("-----Car Info-----");
		super.displayInfo();
		System.out.println("Seat Capacity: "+seatCapacity);
	}
}
