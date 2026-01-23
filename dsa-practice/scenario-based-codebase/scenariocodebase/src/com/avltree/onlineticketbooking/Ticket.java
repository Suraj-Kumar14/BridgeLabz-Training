package com.avltree.onlineticketbooking;

import java.time.LocalTime;

public class Ticket {
	private String event;
	private LocalTime time;
	private int height;
	Ticket left,right;
	
	
	public Ticket(String event, LocalTime time) {
		super();
		this.event = event;
		this.time = time;
		height=1;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getEvent() {
		return event;
	}

		
	public void setEvent(String event) {
		this.event = event;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Ticket [event=" + event + ", time=" + time + "]";
	}
	
	
}
