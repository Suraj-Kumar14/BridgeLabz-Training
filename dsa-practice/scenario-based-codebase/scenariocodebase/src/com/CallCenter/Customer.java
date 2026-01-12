package com.CallCenter;

public class Customer {
	private String name;
	private String phoneNo;
	
	
	public Customer(String name, String phoneNo) {
		this.name = name;
		this.phoneNo=phoneNo;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
}
