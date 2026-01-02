package com.VehicleRentalSystem;

public class Bike extends Vehicle{
	
	public Bike(String id,String brand,double rate) {
		super(id,brand,rate);
	}
	
	@Override
	public double calculateRent(int days) {
		return rate*days;
	}
	
	@Override
	
	public void displayInfo() {
		System.out.println("-----Bike Rent Details-----");
		System.out.println("Bike |Brand: "+brand+" | Rate/day: "+rate);
	}
}
