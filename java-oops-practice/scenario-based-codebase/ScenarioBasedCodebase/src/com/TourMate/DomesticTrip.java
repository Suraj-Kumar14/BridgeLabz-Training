package com.TourMate;

public class DomesticTrip extends Trip{
	
	public DomesticTrip(String destination,int duration,Transport transport,Hotel hotel,Activity activity){
		super(destination,duration,transport,hotel,activity);
	}
	
	@Override
	public void bookTrip() {
		System.out.println("Booking Domestic Trip to "+destination);
		transport.book();
		hotel.book();
		activity.book();
		System.out.println("Local Id verified!");
	}
}
