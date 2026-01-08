package com.medistore;

import java.time.LocalDate;

public abstract class Medicine implements ISellable{
	
	private String name;
	private double price;
	private LocalDate expiryDate;
	private int quantity;
	
	public Medicine(String name,double price,LocalDate expiryDate,int quantity) {
		this.name=name;
		this.price=price;
		this.expiryDate=expiryDate;
		this.quantity=quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate=expiryDate;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public void sell(int quantity) {
		
	}
	
	@Override
	public boolean checkExpiry(LocalDate expiryDate) {
		return false;
	}
	
	public abstract void details();
}
