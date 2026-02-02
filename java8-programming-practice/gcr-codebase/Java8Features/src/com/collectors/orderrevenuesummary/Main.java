package com.collectors.orderrevenuesummary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
		List<Order>orders=new ArrayList<>();
		
		orders.add(new Order("Suraj",800));
		orders.add(new Order("Bholu",700));
		orders.add(new Order("Suraj",600));
		orders.add(new Order("Rahul",300));
		orders.add(new Order("Ravi",500));
		orders.add(new Order("Bholu",500));
		orders.add(new Order("Rahul",600));
		
		orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomerName,Collectors.summingDouble(Order::getTotalOrder))).forEach((k,v)->System.out.println(k+" - "+v));

	}

}
