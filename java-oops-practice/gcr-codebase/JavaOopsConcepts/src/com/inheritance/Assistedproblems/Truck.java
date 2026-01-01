package com.inheritance.Assistedproblems;

public class Truck extends Vehicle {
	 
	public int seatCapacity;
	
	//constructor
	public Truck(int maxSpeed,String fuelType,int seatCapacity) {
		super(maxSpeed,fuelType);
		this.seatCapacity=seatCapacity;
	}
	
	@Override
	public void displayInfo() {
		System.out.println();
		System.out.println("-----Truck Info-----");
		super.displayInfo();
		System.out.println("Seat Capacity: "+seatCapacity);
	}

}
