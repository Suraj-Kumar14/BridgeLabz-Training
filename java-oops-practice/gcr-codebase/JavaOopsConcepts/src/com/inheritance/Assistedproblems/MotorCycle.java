package com.inheritance.Assistedproblems;

public class MotorCycle extends Vehicle {

    public int seatCapacity;
	
	//constructor
	public MotorCycle(int maxSpeed,String fuelType,int seatCapacity) {
		super(maxSpeed,fuelType);
		this.seatCapacity=seatCapacity;
	}
	
	@Override
	public void displayInfo() {
		System.out.println();
		System.out.println("-----MotorCylce Info-----");
		super.displayInfo();
		System.out.println("Seat Capacity: "+seatCapacity);
	}
}
