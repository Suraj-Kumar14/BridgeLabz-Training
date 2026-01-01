package com.inheritance.SingleInheritance;

public class Thermostat extends Device {
	private double temperatureSetting;
	
	//constructor
	public Thermostat(String deviceId,String status,double temperatureSetting) {
		super(deviceId,status);
		this.temperatureSetting=temperatureSetting;
	}
	
	@Override
	public void displayStatus() {
		
		System.out.println("-----Thermostat Device-----");
		super.displayStatus();
		System.out.println("Temperature Status: "+temperatureSetting);
	}
}
