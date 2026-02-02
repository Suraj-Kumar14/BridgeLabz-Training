package com.collectors.orderrevenuesummary;

public class Order {
	private String customerName;
	private double totalOrder;
	
	public Order(String customerName, int totalOrder) {
		super();
		this.customerName = customerName;
		this.totalOrder = totalOrder;
	}
	public String getCustomerName() {
		return customerName;
	}
	public double getTotalOrder() {
		return totalOrder;
	}
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", totalOrder=" + totalOrder + "]";
	}
	
	
}
