package com.inheritance.Multilevelinheritance.OnlineRetailOrderManagement;

public class OrderMain {
	public static void main(String[] args) {
		Order order=new Order(101,"2026-01-01");
		System.out.println("Order Status: "+order.getOrderStatus());
		
		ShippedOrder shippedOrder=new ShippedOrder(102,"2026-01-02","TRK12345");
		System.out.println("Order Status: "+shippedOrder.getOrderStatus());
		
		DeliveredOrder deliveredOrder=new DeliveredOrder(103,"2026-01-03","TRK67890","2026-01-05");
		System.out.println("Order Status: "+deliveredOrder.getOrderStatus());
	}
}
