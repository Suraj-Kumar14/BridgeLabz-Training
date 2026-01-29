package com.defininginterface.rentalsystem;

public class Main {

	public static void main(String[] args) {
		
		Vehicle car=new Car();
		Vehicle bike=new Bike();
		Vehicle bus=new Bus();
		
		car.rent();
		bike.rent();
		bus.rent();
		
		System.out.println();
		
		car.returnVehicle();
		bike.returnVehicle();
		bus.returnVehicle();

	}

}
