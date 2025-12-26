package com.classandobject.Level2;

public class MovieTicket {
	private String movieName;
	private String seatNumber;
	private double price;
	private boolean isBooked;
	
	//Constructor
	MovieTicket(String movieName){
		this.movieName=movieName;
		this.seatNumber="Null";
		this.price=0.0;
		this.isBooked=false;
	}
	
	//Creating the method to book the ticket
	public void bookTicket(String seatNumber,double price) {
		//checking weather the ticket is booked or not
		if(isBooked) {
			System.err.println("House full!!! sorry..... Ticket already booked");
		}
		//getting the details if not booked
		else {
			this.seatNumber=seatNumber;
			this.price=price;
			this.isBooked=true;
			System.out.println("Ticket booked for movie: " + this.movieName);
	        System.out.println("Seat Number: " + this.seatNumber);
	        System.out.println("Price: $" + this.price);
		}
	}
	
	//Creating the method to display the booked tickets
	public void displayTicket() {
		//checking weather the ticket is already booked
		if(this.isBooked) {
			System.out.println("Ticket booked for movie: " + this.movieName);
	        System.out.println("Seat Number: " + this.seatNumber);
	        System.out.println("Price: $" + this.price);	
		}
		//displaying message If failed to book the ticket
		else {
			  System.out.println("Ticket have not booked yet....");
		}
	}
	
	public static void main(String [] args) {
		MovieTicket ticket=new MovieTicket("Dragon");
		ticket.displayTicket();
		ticket.bookTicket("A10",120.0);
		ticket.bookTicket("B10",120.0);
		ticket.bookTicket("A11",120.0);
		ticket.displayTicket();		
	}
}
