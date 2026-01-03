package com.encapsulationandpolymorphism.VehicleRentalSystem;

public abstract class Vehicle implements Insurable {
	 private String vehicleNumber;
	 private String type;
	 protected double rentalRate;
	 private String policyNumber;
	 
	 public Vehicle(String vehicleNumber,String type,double rentalRate,String policyNumber) {
		 this.vehicleNumber=vehicleNumber;
		 this.type=type;
		 this.rentalRate=rentalRate;
		 this.policyNumber=policyNumber;
	 }
	 
	 public String getVehicleNumber() {
		 return vehicleNumber;
	 }
	 
	 public String getType() {
		 return type;
	 }
	 
	 public abstract double calculateRentalCost(int days);
	 
	 protected String getPolicyNumber() {
		 return "****"+policyNumber.substring(policyNumber.length()-4);
	 }
}
