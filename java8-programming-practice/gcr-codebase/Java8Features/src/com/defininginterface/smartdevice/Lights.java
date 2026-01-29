package com.defininginterface.smartdevice;

public class Lights implements SmartDevice{

	@Override
	public void turnOn() {
	System.out.println("Light is turn ON");		
	}

	@Override
	public void turnOff() {
	System.out.println("Light is turn OFF");		
	}

}
