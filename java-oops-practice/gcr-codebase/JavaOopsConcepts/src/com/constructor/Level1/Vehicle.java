package com.constructor.Level1;

public class Vehicle {
	//instance variable
	private String ownerName;
	private String vehicleType;
	
	//class variable
	private static double registrationFee=600;
	
	//constructor
	public Vehicle(String ownerName,String vehicleType) {
		this.ownerName=ownerName;
		this.vehicleType=vehicleType;
	}
	
	//instance method to display vehicle details
	public void displayVehicleDetails() {
		System.out.println("Owner name: "+ownerName);
		System.out.println("Vehicle type: "+vehicleType);
		System.out.println("Registration fee: "+registrationFee);
		System.out.println();
	}
	
	//class method to update registration fee
	public static void updateRegistrationFee(double newRegistrationFee) {
		registrationFee=newRegistrationFee;
	}
}
