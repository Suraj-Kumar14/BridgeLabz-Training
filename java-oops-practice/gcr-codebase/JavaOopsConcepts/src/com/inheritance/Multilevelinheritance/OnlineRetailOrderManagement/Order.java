package com.inheritance.Multilevelinheritance.OnlineRetailOrderManagement;

public class Order {
	protected int orderId;
	protected String orderDate;
	
	//constructor
	public Order(int orderId,String orderDate) {
		this.orderId=orderId;
		this.orderDate=orderDate;
	}
	
	//method to current status of order
	public String getOrderStatus() {
		return "order Placed";
	}
}
