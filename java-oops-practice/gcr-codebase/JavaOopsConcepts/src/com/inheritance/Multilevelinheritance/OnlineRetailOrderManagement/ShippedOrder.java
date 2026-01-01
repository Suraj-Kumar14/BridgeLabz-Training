package com.inheritance.Multilevelinheritance.OnlineRetailOrderManagement;

public class ShippedOrder extends Order {
	protected String trackingNumber;
	
	//constructor
	public ShippedOrder(int orderId,String orderDate,String trackingNumber) {
		super(orderId,orderDate);
		this.trackingNumber=trackingNumber;
	}
	
	@Override
	public String getOrderStatus() {
		return "Order Shipped";
	}
}
