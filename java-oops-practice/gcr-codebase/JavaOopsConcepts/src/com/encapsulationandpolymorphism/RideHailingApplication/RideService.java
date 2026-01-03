package com.encapsulationandpolymorphism.RideHailingApplication;

public class RideService {

    public static void calculateRideFare(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: " + vehicle.calculateFare(distance));
        System.out.println("--------------------------------");
    }
}
