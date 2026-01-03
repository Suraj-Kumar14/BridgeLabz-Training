package com.encapsulationandpolymorphism.VehicleRentalSystem;

public class Car extends Vehicle {
		
		public Car(String vehicleNumber,double rentalRate,String policyNumber) {
			super(vehicleNumber,"Car",rentalRate,policyNumber);
		}
		
		@Override
		public double calculateRentalCost(int days) {
			return rentalRate*days;
		}

		@Override
		public double calculateInsurance() {
			return 500.0;			
		}

		@Override
		public String getInsuranceDetails() {
			return "Car Insurance | Policy: "+getPolicyNumber();
			
		}
}
