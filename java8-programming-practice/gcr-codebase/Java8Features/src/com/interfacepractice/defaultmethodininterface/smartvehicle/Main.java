package com.interfacepractice.defaultmethodininterface.smartvehicle;

public class Main {

	public static void main(String[] args) {
		
		Vehicle car=new Car();
		Vehicle ev=new ElectricVehicle();
		
		car.displaySpeed(80);
		car.displayBattery(50);
		
		ev.displaySpeed(70);
		ev.displayBattery(57);

	}

}
