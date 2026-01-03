package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Bike extends Vehicle{
	public Bike(String vehicleNumber,double rentalRate,String policyNumber) {
		super(vehicleNumber,"Bike",rentalRate,policyNumber);
	}
	
	@Override
	public double calculateRentalCost(int days) {
		return rentalRate*days;
	}

	@Override
	public double calculateInsurance() {
		return 200.0;			
	}

	@Override
	public String getInsuranceDetails() {
		return "Bike Insurance | Policy: "+getPolicyNumber();
		
	}
}
