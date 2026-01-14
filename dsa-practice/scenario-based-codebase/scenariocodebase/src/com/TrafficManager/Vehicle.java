package com.TrafficManager;

public class Vehicle {
	String vehicleNo;
	Vehicle next;
	
	public Vehicle(String vehicleNo) {
		this.vehicleNo=vehicleNo;
		this.next=null;
	}
}
