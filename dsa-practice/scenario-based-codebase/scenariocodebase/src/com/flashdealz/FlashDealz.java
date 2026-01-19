package com.flashdealz;

public class FlashDealz {

	public static void main(String[] args) {
		
		ECommerce ecom=new ECommerce();
		
		ecom.addProduct(new Product("PC",22000,25));
		ecom.addProduct(new Product("crystal Bottel",245,14));
		ecom.addProduct(new Product("Chair",4000,15));
		ecom.addProduct(new Product("Laptop",54500,32));
		ecom.addProduct(new Product("Freeze",14999,18));
		ecom.addProduct(new Product("Washing Machine",18999,28));
		ecom.addProduct(new Product("T.V",24500,30));

		System.out.println("Product before sorting.");
		ecom.showProduct();
		ecom.sortProduct();
		ecom.showProduct();
		
		

	}

}
