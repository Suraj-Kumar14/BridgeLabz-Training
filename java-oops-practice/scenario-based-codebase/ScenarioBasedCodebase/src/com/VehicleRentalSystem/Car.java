package com.VehicleRentalSystem;

public class Car extends Vehicle{
	private double luxuryCarge=500;
	public Car(String id,String brand,double rate) {
		super(id,brand,rate);
	}
	
	@Override
	public double calculateRent(int days) {
		return rate*days+500;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("---------Car Rent Details---------");
		System.out.println("Car | Brand: "+brand+" | Rent/day: "+rate);
		
	}

}
