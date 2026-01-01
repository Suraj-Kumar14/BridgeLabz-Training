package com.inheritance.HybridInheritance.VehicleManagementSystem;

public class VehicleMain {
	public static void main(String [] args) {
		ElectricVehicle ev=new ElectricVehicle("Tesla Model 3",225);
		PetrolVehicle pv=new PetrolVehicle("Toyota Corolla",180);
		
		ev.displayDetails();
		ev.charge();
		System.out.println();
		
		pv.displayDetails();
		pv.refuel();
	}
}
