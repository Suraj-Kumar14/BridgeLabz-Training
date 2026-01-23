package com.avltree.onlineticketbooking;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("H:mm");
		
		TicketBooking ticket=new TicketBooking();
		
		ticket.addEvent("Marriage",LocalTime.parse("10:00",formatter));
		ticket.addEvent("Birthday party",LocalTime.parse("19:00",formatter));
		ticket.addEvent("Anniversery",LocalTime.parse("21:00",formatter));
		ticket.addEvent("Puja",LocalTime.parse("9:00",formatter));
		ticket.addEvent("Sangeet",LocalTime.parse("13:00",formatter));
		
		ticket.showTicket();
		
		ticket.cancelEvent(LocalTime.parse("21:00",formatter));
		ticket.showTicket();
		
		ticket.cancelEvent(LocalTime.parse("10:00",formatter));
		ticket.showTicket();
		
		ticket.cancelEvent(LocalTime.parse("9:00",formatter));
		ticket.showTicket();
	}

}
