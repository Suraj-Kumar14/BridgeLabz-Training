package com.tailorshop;

import java.util.ArrayList;
import java.util.List;

public class TailorShop {
	
	List<Order>orders=new ArrayList<>();
	
	//add order
	public void addOrder(Order order) {
		orders.add(order);
		System.out.println("Order added to shop.");
	}
	
	//sort order
	public void sortOrder() {
		int n=orders.size();
		for(int i=1;i<n;i++) {
			Order top=orders.get(i);
			int j=i-1;
			while(j>=0 && orders.get(j).getTime().isAfter(top.getTime())) {
				orders.set(j+1,orders.get(j));
				j--;
			}
			orders.set(j+1, top);
		}
	}
	
	//show order
	public void showOrder(){
		System.out.println("-----Order Details-----");
		if(!orders.isEmpty()) {
			for(Order order:orders) {
				System.out.println(order);
			}
		}else {
			System.out.println("No item Ordered");
		}
		System.out.println();
	}
}
