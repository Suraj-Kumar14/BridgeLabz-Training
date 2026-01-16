package com.payxpress;

import java.time.LocalDate;

public class Bill {
	private String type;
	private double amount;
	private LocalDate dueDate;
	private boolean isPaid;
	
	public Bill(String type, double amount, LocalDate dueDate, boolean isPaid) {
		
		this.type = type;
		this.amount = amount;
		this.dueDate = dueDate;
		this.isPaid = isPaid;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
		
}
