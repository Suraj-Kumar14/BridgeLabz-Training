package com.constructor.Level1;

public class HotelBooking {
	//attributes
	private String guestName;
	private String roomType;
	private int nights;
	
	//Default constructor
	public HotelBooking() {
		this("Unknown","Double",2);
	}
	
	//parametrized constructor
	public HotelBooking(String guestName,String roomType,int nights) {
		this.guestName=guestName;
		this.roomType=roomType;
		this.nights=nights;
	}
	
	//copy constructor
	public HotelBooking(HotelBooking data) {
		this.guestName=data.guestName;
		this.roomType=data.roomType;
		this.nights=data.nights;
	}
	
	//display Hotel Booking details
	public void displayBookingDetails() {
		System.out.println("Guest Name: "+guestName);
		System.out.println("Room Type: "+roomType);
		System.out.println("Nights: "+nights);
		System.out.println();
	}
}
