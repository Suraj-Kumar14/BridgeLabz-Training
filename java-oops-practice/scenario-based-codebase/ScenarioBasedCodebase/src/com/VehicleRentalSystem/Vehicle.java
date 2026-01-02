package com.VehicleRentalSystem;

abstract class Vehicle implements Rentable{
	protected String vehicleId;
	protected String brand;
	protected double rate;
	
	//constructor 
	public Vehicle(String vehicleId,String brand, double rate) {
		this.vehicleId=vehicleId;
		this.brand=brand;
		this.rate=rate;
	}
	
	//getter
	public String getVehicleId() {
		return vehicleId;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public double getRate() {
		return rate;
	}
	
	public abstract void displayInfo();
}
