package com.interfacepractice.defaultmethodininterface.smartvehicle;

public class ElectricVehicle implements Vehicle{

	@Override
	public void displaySpeed(int speed) {
		System.out.println("\nElectric Vehicle Speed: "+speed+" km/h");		
	}
	
	@Override
	public void displayBattery(int percentage) {
		System.out.println("Battery level: "+percentage+"%");
	}

}
