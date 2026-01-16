package com.homenest;

public class Thermostat extends Device implements IControllable{

	public Thermostat(double energyUsage) {
		super(true, energyUsage);
	}

	@Override
	public void turnOn() {
		System.out.println("Thermostat On.");
	}

	@Override
	public void turnOff() {
		System.out.println("Thermostat Off.");
	}

	@Override
	public void reset() {
		System.out.println("Thermostat Reset.");
	}
}