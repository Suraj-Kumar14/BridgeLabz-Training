package com.ridehailingapp;

public class CabService implements IRideService {
	private double fare;
	private boolean isActive;
	
	@Override
	public void bookRide(Driver driver, Vehicle vehicle, double distance) {
		double baseFare = 50;
		fare = baseFare + distance*vehicle.getRatePerKM();
		isActive = true;
		
		System.out.println("---------------Ride Booked---------------");
		System.out.println("Driver Name: "+driver.getDriverInfo());
		System.out.println("Vehicle :"+vehicle.getVehicleInfo());
		System.out.println("Distance: "+ distance+"km");
		System.out.println("Total amount: "+baseFare);
	}

	@Override
	public void endRide() {
		if(isActive) {
			isActive = false;
			System.out.println("Ride ended: Total fee-> "+fare);
		}else {
			System.out.println("No active ride!");
		}
	}
}