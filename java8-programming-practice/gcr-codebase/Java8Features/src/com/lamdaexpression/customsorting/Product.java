package com.lamdaexpression.customsorting;

public class Product {
	
	private String name;
	private double price;
	private double rating;
	private double discount;
	
	public Product(String name, double price, double rating, double discount) {
		super();
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.discount = discount;
	}
	
	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", rating=" + rating + ", discount=" + discount + "]";
	}
	
	
	
}
