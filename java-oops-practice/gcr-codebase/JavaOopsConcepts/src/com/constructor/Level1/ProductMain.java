package com.constructor.Level1;

public class ProductMain {
	public static void main(String[] args) {
		//create object to invoke constructor
		Product product1=new Product("Freeze",12500.0);
		Product product2=new Product("Washing machine",10999.0);
		Product product3=new Product("Television",24500.0);
		
		//calling displayProductDetails method
		product1.displayproductDetails();
		product2.displayproductDetails();
		product3.displayproductDetails();
		
		//calling class method
		Product.displayTotalProducts();
		
	}
}