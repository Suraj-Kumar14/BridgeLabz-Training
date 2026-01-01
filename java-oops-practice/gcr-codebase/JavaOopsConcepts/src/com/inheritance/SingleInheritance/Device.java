package com.inheritance.SingleInheritance;

public class Device {
	protected String deviceId;
	protected String status;
	
	//constructor
	public Device(String deviceId,String status) {
		this.deviceId=deviceId;
		this.status=status;
	}
	
	//display method
	public void displayStatus() {
		System.out.println("Device deviceId: "+deviceId);
		System.out.println("Device Status: "+status);
	}
}
