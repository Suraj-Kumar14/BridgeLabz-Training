package com.homenest;

public class Light extends Device implements IControllable{
	
	public Light(double energyUsage) {
		super(true,energyUsage);
	}

	@Override
	public void turnOn() {
		System.out.println("Light On.");
	}

	@Override
	public void turnOff() {
		System.out.println("Light Off.");
	}

	@Override
	public void reset() {
		System.out.println("Light Reset.");
	}	
}