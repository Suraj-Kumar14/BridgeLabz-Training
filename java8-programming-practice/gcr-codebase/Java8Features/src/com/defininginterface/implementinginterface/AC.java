package com.defininginterface.implementinginterface;

public class AC implements SmartDevice{

	@Override
	public void turnOn() {
		System.out.println("AC is turn ON");		
	}

	@Override
	public void turnOff() {
		System.out.println("AC is turn OFF");		
	}

}
