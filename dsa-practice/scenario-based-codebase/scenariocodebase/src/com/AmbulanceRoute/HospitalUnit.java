package com.AmbulanceRoute;

public class HospitalUnit {
	private String name;
	protected boolean available;
	HospitalUnit next;
	public HospitalUnit(String name, boolean available) {
		super();
		this.name = name;
		this.available = available;
		this.next=null;
	}
	
	public String getName() {
		return name;
	}
	
}
