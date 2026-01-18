package com.eventmanager;

public class Ticket {
	private int ticketId;
	private double price;

	public Ticket(int ticketId,double price) {
		this.ticketId = ticketId;
		this.price=price;
	}

	public int getTicketId() {
		return ticketId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "TicketID: "+ticketId+" || Price: "+price;
	}
}
