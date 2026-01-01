package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class Vehicle {
	protected int maxSpeed;
	protected String model;
	
	public Vehicle(String model,int maxSpeed) {
		this.model=model;
		this.maxSpeed=maxSpeed;
	}
	
	public void displayDetails() {
		System.out.println("Model: "+model+", Max Speed: "+maxSpeed+" km/h");
	}
}
