package com.VehicleRentalSystem;

public class Truck extends Vehicle {
	private double loadCharge=1000;
	public Truck(String id,String brand,double rate) {
		super(id,brand,rate);
	}
	
	@Override
	public double calculateRent(int days) {
		return rate*days+loadCharge;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("------Truck Rent Details------");
		System.out.println("Truck | Brand: "+brand+" |Rate/day: "+rate);
	}

}
