package com.workshoponjava8features.smartcitytransport;

public class Transport {
	private String route;
	private double fare;
	private int departureTime;
	
	public Transport(String route, double fare, int departureTime) {
		this.route = route;
		this.fare = fare;
		this.departureTime = departureTime;
	}

	public String getRoute() {
		return route;
	}

	public double getFare() {
		return fare;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	@Override
	public String toString() {
		return "Transport [route=" + route + ", fare=" + fare + ", departureTime=" + departureTime + "]";
	}
}
