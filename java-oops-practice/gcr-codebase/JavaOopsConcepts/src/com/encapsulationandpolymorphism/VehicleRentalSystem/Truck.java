package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Truck extends Vehicle {
	public Truck(String vehicleNumber,double rentalRate,String policyNumber) {
		super(vehicleNumber,"Bike",rentalRate,policyNumber);
	}
	
	@Override
	public double calculateRentalCost(int days) {
		return rentalRate*days;
	}

	@Override
	public double calculateInsurance() {
		return 1000.0;			
	}

	@Override
	public String getInsuranceDetails() {
		return "Truck Insurance | Policy: "+getPolicyNumber();
		
	}
}
