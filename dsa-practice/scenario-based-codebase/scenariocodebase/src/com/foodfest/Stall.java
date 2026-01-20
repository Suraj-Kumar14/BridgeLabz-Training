package com.foodfest;

public class Stall {
	private String stallName;
	private int customerFootfall;
	
	public Stall(String stallName, int customerFootfall) {
		this.stallName = stallName;
		this.customerFootfall = customerFootfall;
	}
	
	public String getStallName() {
		return stallName;
	}
	
	public int getCustomerFootfall() {
		return customerFootfall;
	}
	
	@Override
	public String toString() {
		return "Stall [stallName=" + stallName + ", customerFootfall=" + customerFootfall + "]";
	}	
}
