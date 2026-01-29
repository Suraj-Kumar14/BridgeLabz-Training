package com.defininginterface.implementinginterface;

public class TV implements SmartDevice{

	@Override
	public void turnOn() {
		System.out.println("TV is turn ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV is turn OFF");
		
	}

}
