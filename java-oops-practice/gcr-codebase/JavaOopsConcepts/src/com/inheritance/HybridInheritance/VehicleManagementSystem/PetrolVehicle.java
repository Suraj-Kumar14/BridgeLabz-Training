package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class PetrolVehicle extends Vehicle implements Refuelable {
	
	//constructor
	PetrolVehicle(String model,int maxSpeed){
		super(model,maxSpeed);
	}
	
	@Override
	public void refuel() {
		System.out.println("Petrol vehicle is being refueled");
	}
}
