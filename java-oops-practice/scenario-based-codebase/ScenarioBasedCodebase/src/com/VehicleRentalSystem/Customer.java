package com.VehicleRentalSystem;

public class Customer {
	private int customerId;
	private String customerName;
	
	public Customer(int customerId,String customerName) {
		this.customerId=customerId;
		this.customerName=customerName;
	}
	public void displayCustomer() {
		System.out.println("Customer ID: "+customerId+", Name: "+customerName);
	}
}
