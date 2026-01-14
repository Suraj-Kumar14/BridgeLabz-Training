package com.smartcheckout;

public class Customer {
	String name;
	String mobNo;
	public Customer(String name, String mobNo) {
		this.name = name;
		this.mobNo = mobNo;
	}
	
	 @Override
	    public String toString() {
	        return "Customer [Name=" + name + ", Mobile No=" + mobNo + "]";
	    }


	
}
