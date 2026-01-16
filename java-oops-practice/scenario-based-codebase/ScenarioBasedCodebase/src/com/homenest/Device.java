package com.homenest;

public class Device {
	static int count=100;
	
	private int deviceId;
	private boolean status;
	private double energyUsage;

	public Device(boolean status, double energyUsage) {
		this.deviceId = count++;
		this.status = status;
		this.energyUsage = energyUsage;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public boolean isStatus() {
		return status;
	}

	public double getEnergyUsage() {
		return energyUsage;
	}
}