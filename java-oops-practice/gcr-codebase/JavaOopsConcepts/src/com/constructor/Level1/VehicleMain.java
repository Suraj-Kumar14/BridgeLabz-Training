package com.constructor.Level1;

public class VehicleMain {

	public static void main(String[] args) {
		Vehicle vehicle=new Vehicle("Virat","Four-wheeler"); //invoke constructor
		
		//Display vehicle details
		vehicle.displayVehicleDetails(); 
		//update registration fee
		Vehicle.updateRegistrationFee(650.0);
		vehicle.displayVehicleDetails();		
	}
}
