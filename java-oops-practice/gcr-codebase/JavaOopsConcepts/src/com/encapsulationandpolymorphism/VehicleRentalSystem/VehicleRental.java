package com.encapsulationandpolymorphism.VehicleRentalSystem;
import java.util.ArrayList;
import java.util.List;
public class VehicleRental {

	public static void main(String[] args) {
		
		List<Vehicle>vehicles=new ArrayList<>();
		
		vehicles.add(new Car("CAR101", 1500, "POL12345"));
        vehicles.add(new Bike("BIKE202", 500, "POL67890"));
        vehicles.add(new Truck("TRK303", 3000, "POL54321"));
        
        int days=3;
        
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Rental Cost: " + v.calculateRentalCost(days));
            System.out.println("Insurance Cost: " + v.calculateInsurance());
            System.out.println(v.getInsuranceDetails());
            System.out.println("-------------------------");
        }
	}

}
