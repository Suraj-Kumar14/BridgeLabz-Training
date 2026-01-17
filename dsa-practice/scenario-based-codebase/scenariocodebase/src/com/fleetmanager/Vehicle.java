package com.fleetmanager;

public class Vehicle {
	
	private String name;
	private String id;
	private int mileage;
	
	public Vehicle(String name, String id, int mileage) {
		this.name = name;
		this.id = id;
		this.mileage = mileage;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getMileage() {
		return mileage;
	}

	public String toString() {
		return "Vehicle name: "+name+" || ID: "+id+" || Mileage: "+mileage;
	}
		
}
