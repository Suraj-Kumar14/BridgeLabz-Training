package com.constructor.Level1;

public class Product {
	//attributes
	private String productName;
	private double price;
	private static int totalProducts=0;
	
	//constructor
	Product(String productName,double price){
		this.productName=productName;
		this.price=price;
		totalProducts++;
	}
	
	//Instance method to display the details
	public void displayproductDetails() {
		System.out.println("Product name: "+productName);
		System.out.println("price: "+price);
	}
	
	//class method to display total products
	public static void displayTotalProducts() {
		System.out.println("Total number of product: "+totalProducts);
	}
}
