package com.eventmanager;

public class Main {
	public static void main(String[] args) {
		
		TicketManager tm=new TicketManager();
		
		tm.addTicket(new Ticket(101,22000));		
		tm.addTicket(new Ticket(102,21000));
		tm.addTicket(new Ticket(103,25000));
		tm.addTicket(new Ticket(104,29000));
		tm.addTicket(new Ticket(105,24999));
		tm.addTicket(new Ticket(106,31000));
		tm.addTicket(new Ticket(107,33000));
		tm.addTicket(new Ticket(108,21500));
		tm.addTicket(new Ticket(109,27000));
		tm.addTicket(new Ticket(110,21999));
		tm.addTicket(new Ticket(111,28500));
		tm.addTicket(new Ticket(112,28000));
		System.out.println();
		tm.showTicket();
		tm.sortTicket();
		System.out.println();
		tm.showTicket();
	}
}
