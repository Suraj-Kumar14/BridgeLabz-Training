package com.encapsulationandpolymorphism.RideHailingApplication;

public class RideHailingTest {
    public static void main(String[] args) {

        Vehicle car = new Car(1, "Amit", 15);
        Vehicle bike = new Bike(2, "Ravi", 8);
        Vehicle auto = new Auto(3, "Suresh", 10);

        RideService.calculateRideFare(car, 10);
        RideService.calculateRideFare(bike, 10);
        RideService.calculateRideFare(auto, 10);
    }
}
