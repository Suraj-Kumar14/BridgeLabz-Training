package com.parkEase;
import java.util.*;
public class Customer{
	//here all logic of user
	
	static List<Vehicle> userVehicle = new ArrayList<>();
	
	
	//part vehicle
	public void parkVehicle(Vehicle newVehicle) {
		userVehicle.add(newVehicle);
		for(ParkingSlot slots:ParkingManagement.parkingSlots) {
			if(slots.getVehicleTypeAllowed().equals(newVehicle.getType())) {
				slots.setOccupied(false);
				System.out.println(newVehicle.getType()+" Parked!");
				return;
			}
		}
		System.out.println("Slot full!");
	}
	
	//remove vehicle
	public void exitVehicle(String vehicleId) {
		for(Vehicle vh: userVehicle) {
			if(vh.getVehicleId().equals(vehicleId)) {
				
			}
		}
	}
	
}