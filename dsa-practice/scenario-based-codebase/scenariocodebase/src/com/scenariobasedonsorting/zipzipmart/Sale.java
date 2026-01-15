package com.scenariobasedonsorting.zipzipmart;

import java.time.LocalDate;

public class Sale {
	private LocalDate date;
	private double amount;	
	
	public Sale(LocalDate date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public double getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return "Date: "+date+"\nAmount: "+amount;
	}
	
}
