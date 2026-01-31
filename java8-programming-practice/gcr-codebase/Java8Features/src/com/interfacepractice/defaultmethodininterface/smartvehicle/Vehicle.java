package com.interfacepractice.defaultmethodininterface.smartvehicle;

public interface Vehicle {
	void displaySpeed(int speed);
	
	default void displayBattery(int batteryPer) {
		System.out.println("Battery feature not available for this vehicle");
	}
}
