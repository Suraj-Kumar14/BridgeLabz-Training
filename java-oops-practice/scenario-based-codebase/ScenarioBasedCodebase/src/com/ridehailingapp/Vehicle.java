package com.ridehailingapp;

public class Vehicle {
	private String vehicleNumber;
	protected int capacity;
	private String type;
	private double ratePerKM;
	public Vehicle(String vehicleNumber, int capacity, String type, double ratePerKM) {
		this.vehicleNumber = vehicleNumber;
		this.capacity = capacity;
		this.type = type;
		this.ratePerKM = ratePerKM;
	}

	public String getVehicleInfo() {
		return type + "[ " + vehicleNumber + " ]";
	}
	
	public double getRatePerKM() {
		return ratePerKM;
	}
}