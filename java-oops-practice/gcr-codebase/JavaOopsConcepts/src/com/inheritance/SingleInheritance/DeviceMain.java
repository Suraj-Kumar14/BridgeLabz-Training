package com.inheritance.SingleInheritance;

public class DeviceMain {
	public static void main(String[] args) {
		Device thermostat=new Thermostat("TS1234","Active",24.0);
		
		thermostat.displayStatus();
	}
}
