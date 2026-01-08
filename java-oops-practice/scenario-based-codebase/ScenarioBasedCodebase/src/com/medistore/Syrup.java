package com.medistore;

import java.time.LocalDate;

public class Syrup extends Medicine{
		
	public Syrup(String name,double price,LocalDate expiryDate,int quantity) {
		super(name,price,expiryDate,quantity);
	}
	
	@Override 
	public void sell(int quantity) {
		if((!checkExpiry(LocalDate.now())) && (getQuantity()>=quantity)) {
			System.out.println("\n-----------Bill-----------");
			System.out.println("Name         :"+getName());
			System.out.println("Price        :"+getPrice());
			System.out.println("Total Amount :"+getPrice()*quantity);
			System.out.println("Expiry Date  :"+getExpiryDate());
			
			setQuantity(getQuantity()-quantity);
		}else {
			System.out.println("Medicine Not Available!");
		}
		System.out.println();
	}
	
	@Override
	public boolean checkExpiry(LocalDate date) {
		return date.isAfter(getExpiryDate())||date.isEqual(getExpiryDate());
	}
	
	@Override
	public void details() {
		System.out.println("\n--------Medicine Details--------");
		System.out.println("Name of medicine:"+getName());
		System.out.println("Price           :"+getPrice());
		System.out.println("Available       :"+getQuantity());
		System.out.println("Expiry Date     :"+getExpiryDate());
	}
}
