package com.homenest;

public class Main {
	
	public static void main(String[] args) {
		User amit = new User("Amit Kumar");
		
		//device
		Device camera = new Camera(12.3);
		Device light = new Light(10);
		Device lock = new Lock(25.3);
		Device thermostat = new Thermostat(17.5);
		
		
		HomeManagement management = new HomeManagement(amit);
		management.turnOffDevice(thermostat);
		management.turnOffDevice(lock);
		management.turnOffDevice(camera);
		management.turnOffDevice(light);
		
		management.turnOnDevice(thermostat);
		
		management.resetDevice(light);
	}
}
