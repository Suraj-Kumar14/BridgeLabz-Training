package com.streamAPI.expiringmemberships;

import java.time.LocalDate;

public class Gym {
		
	private String name;
	private LocalDate expiryDate;
	
	public Gym(String name, LocalDate expiryDate) {
		super();
		this.name = name;
		this.expiryDate = expiryDate;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", expiryDate=" + expiryDate + "]";
	}
	
	
}
