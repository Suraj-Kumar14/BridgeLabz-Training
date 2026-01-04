package com.ridehailingapp;

public interface IRideService {
	public void bookRide(Driver driver,Vehicle vehicle,double distance);
	public void endRide();
}
