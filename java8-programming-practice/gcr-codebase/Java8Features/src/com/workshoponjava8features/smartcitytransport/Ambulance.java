package com.workshoponjava8features.smartcitytransport;

public class Ambulance implements TransportService,EmergencyService{

	@Override
	public String getServicename() {
		return "Ambulance";
	}

	@Override
	public String getRoute() {		
		return "emergency route";
	}

	@Override
	public double getFare() {		
		return 0;
	}

	@Override
	public int getDepartureTime() {
		return 0;
	}

}
