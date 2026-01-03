package com.encapsulationandpolymorphism.RideHailingApplication;

public abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    protected double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId +
               ", Driver: " + driverName +
               ", Rate/Km: " + ratePerKm;
    }
}
