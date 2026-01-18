package com.eventmanager;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {

	List<Ticket>tickets=new ArrayList<>();
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		System.out.println("Ticket added..");
	}
	
	public void sortTicket() {
		int start=0, end=tickets.size()-1;
		
		quickSort(start,end);
		System.out.println("Tickets have been sorted!");
	}
	
	private void quickSort(int start, int end) {
		if(start<end) {
			int pi=partition(start,end);
			
			quickSort(start,pi-1);
			quickSort(pi+1,end);
		}
	}
	
	private int partition(int start, int end) {
		int i=start-1;
		
		for(int j=start;j<end;j++) {
			if(tickets.get(j).getPrice()<tickets.get(end).getPrice()) {
				i++;
				Ticket temp=tickets.get(i);
				tickets.set(i, tickets.get(j));
				tickets.set(j, temp);
			}
		}
		
		i++;
		Ticket temp=tickets.get(i);
		tickets.set(i, tickets.get(end));
		tickets.set(end, temp);
		
		return i;
	}
	
	
	public void showTicket() {
		System.out.println("---------Tickets---------");
		if(!tickets.isEmpty()) {
			for(Ticket ticket:tickets) {
				System.out.println(ticket);
			}
		}else {
			System.out.println("No ticket available");
		}
		System.out.println();
	}
}
