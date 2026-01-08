package com.parkEase;

public class ParkingSlot {
	private int slotId;
	private boolean isOccupied;
	private String vehicleTypeAllowed;
	
	public ParkingSlot(int slotId, boolean isOccupied, String vehicleTypeAllowed) {
		this.slotId = slotId;
		this.isOccupied = isOccupied;
		this.vehicleTypeAllowed = vehicleTypeAllowed;
	}
	
	//method
	public void getDetails() {
		System.out.println("Slot Id: "+slotId);
		System.out.println("Is Occupied: "+isOccupied);
		System.out.println("Vehicle Type: "+vehicleTypeAllowed);
	}

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public String getVehicleTypeAllowed() {
		return vehicleTypeAllowed;
	}

	public void setVehicleTypeAllowed(String vehicleTypeAllowed) {
		this.vehicleTypeAllowed = vehicleTypeAllowed;
	}
}