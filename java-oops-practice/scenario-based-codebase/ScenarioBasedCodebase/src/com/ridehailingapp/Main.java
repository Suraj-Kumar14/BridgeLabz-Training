package com.ridehailingapp;

public class Main {

	public static void main(String[] args) {
		Driver driver = new Driver("Suraj", "MP2345", 4.8);

        Vehicle myCar = new Sedan("KA01AB1242");

        IRideService rideService = new CabService();

        rideService.bookRide(driver, myCar, 10);
        rideService.endRide();
	}
}