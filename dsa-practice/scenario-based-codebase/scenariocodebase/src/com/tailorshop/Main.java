package com.tailorshop;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:MM");
		TailorShop shop=new TailorShop();
		shop.addOrder(new Order("T-Shirt",LocalTime.parse("10:00",formatter)));
		shop.addOrder(new Order("Jogger",LocalTime.parse("08:00",formatter)));
		shop.addOrder(new Order("Jeans",LocalTime.parse("12:00",formatter)));
		shop.addOrder(new Order("T-Shirt",LocalTime.parse("06:00",formatter)));
		shop.addOrder(new Order("T-Shirt",LocalTime.parse("14:00",formatter)));
		System.out.println("Before sorting");
		shop.showOrder();
		shop.sortOrder();
		System.out.println("After sorting");
		shop.showOrder();
	}

}
