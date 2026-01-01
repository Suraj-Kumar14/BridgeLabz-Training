package com.inheritance.Multilevelinheritance.OnlineRetailOrderManagement;

public class DeliveredOrder extends ShippedOrder {
	private String deliveryDate;
	
	//constructor
	public DeliveredOrder(int orderId,String orderDate,String trackingNumber,String deliveryDate) {
		super(orderId,orderDate,trackingNumber);
		this.deliveryDate=deliveryDate;
	}
	
	@Override
	public String getOrderStatus() {
		return "Order Delivered";
	}
}
