package com.workshoponjava8features.smartcitytransport;

public class Bus extends Transport implements TransportService{

	public Bus(String route, double fare, int departureTime) {
		super(route, fare, departureTime);
	}

	@Override
	public String getServicename() {
		return "Bus";
	}

	
}
