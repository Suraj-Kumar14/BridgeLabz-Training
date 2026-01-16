package com.homenest;

public class Camera extends Device implements IControllable{

	public Camera(double energyUsage) {
		super(true, energyUsage);
	}

	@Override
	public void turnOn() {
		System.out.println("Camera On.");
	}

	@Override
	public void turnOff() {
		System.out.println("Camera Off.");
	}

	@Override
	public void reset() {
		System.out.println("Camera Reset.");
	}
}