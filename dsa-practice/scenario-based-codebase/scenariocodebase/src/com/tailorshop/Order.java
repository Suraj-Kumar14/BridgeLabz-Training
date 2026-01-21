package com.tailorshop;

import java.time.LocalTime;

public class Order {
	private String orderName;
	private LocalTime time;
	
	public Order(String orderName, LocalTime time) {
		this.orderName = orderName;
		this.time = time;
	}
	
	public String getOrderName() {
		return orderName;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", time=" + time + "]";
	}	
}
