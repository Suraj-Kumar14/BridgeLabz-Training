package com.TrafficManager;

public class Main {
	
	public static void main(String[] args) {
		TrafficManagement manager=new TrafficManagement();
		
		manager.addVehicle("MP04 1234");
		manager.addVehicle("DL01 1343");
		manager.addVehicle("HR01 2343");
		manager.addVehicle("IN01 3343");
		manager.addVehicle("MP01 4343");
		manager.addVehicle("BR07 5343");
		manager.addVehicle("BR09 6343");
		manager.addVehicle("BR27 7343");
		manager.addVehicle("UP01 8343");
		manager.addVehicle("PUN01 9343");
		manager.addVehicle("WB01 2743");
		
		manager.show();
		
		manager.remove("MP04 1234");
		manager.remove("HR01 2343");
		manager.remove("PUN01 9343");
		manager.remove("WB01 2743");
		manager.show();
	}
}
