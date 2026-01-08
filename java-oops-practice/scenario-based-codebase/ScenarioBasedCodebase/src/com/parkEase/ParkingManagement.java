package com.parkEase;
import java.util.*;

public class ParkingManagement {
	//this class manage all vehicle 
	static List<ParkingSlot> parkingSlots = new ArrayList<>();
	
	//add parking slot
	public void addParkingSlot(ParkingSlot slot) {
		parkingSlots.add(slot);
	}
	
	//remove parking slot
	public void removeParkingSlot(ParkingSlot slot) {
		parkingSlots.remove(slot);
	}
	
	//view parking slot
	public void viewSlot() {
		int i = 0;
		System.out.println("----------------------List of Parking Slot----------------------------");
		for(ParkingSlot slots : parkingSlots) {
			System.out.println("-----------------Slot "+ (i) +" -------------");
			slots.getDetails();
			i+=1;
		}
		System.out.println("----------------------------------------------------------------------");
	}
}