package com.homenest;

public class Lock extends Device implements IControllable{

	public Lock(double energyUsage) {
		super(true, energyUsage);
	}

	@Override
	public void turnOn() {
		System.out.println("Lock On");
	}

	@Override
	public void turnOff() {
		System.out.println("Lock Off.");
	}

	@Override
	public void reset() {
		System.out.println("Lock Reset.");
	}
}