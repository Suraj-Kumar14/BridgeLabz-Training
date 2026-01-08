package com.TourMate;

public class Main {

	public static void main(String[] args) {
		
		Transport transport=new Transport(25000);
		Hotel hotel=new Hotel(12000);
		Activity activity= new Activity(15000);
		
		Trip trip=new InternationalTrip("London",7,transport,hotel,activity);
		
		trip.bookTrip();
		System.out.println("Total Budget: "+trip.getTotalBudget());
	}

}
