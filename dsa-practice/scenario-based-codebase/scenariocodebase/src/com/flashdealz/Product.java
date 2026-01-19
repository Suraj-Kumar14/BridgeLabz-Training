package com.flashdealz;

public class Product {
	private String name;
	private double price;
	private double discount;
	public Product(String name, double price, double discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", discount=" + discount + ", Discounted Price=" +(price- price*discount/100)
				+ "]";
	}	
	
}
