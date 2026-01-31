package com.interfacepractice.defaultmethodininterface.smartvehicle;

public class Car implements Vehicle{

	@Override
	public void displaySpeed(int speed) {
		System.out.println("\nCar speed: "+speed+" km/h");
		
	}

}
