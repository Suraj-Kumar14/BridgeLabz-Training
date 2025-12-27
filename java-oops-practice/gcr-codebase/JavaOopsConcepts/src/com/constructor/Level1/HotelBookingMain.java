package com.constructor.Level1;

public class HotelBookingMain {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Invoke Default constructor and display details
		HotelBooking booking1=new HotelBooking();
		booking1.displayBookingDetails();
			
		//invoke parametrized constructor and display details
		HotelBooking booking2=new HotelBooking("Suraj","Single",1);
		booking2.displayBookingDetails();
			
		//invoke copy constructor and display details
		HotelBooking booking3=new HotelBooking(booking2);
		booking3.displayBookingDetails();		
	}	
}
