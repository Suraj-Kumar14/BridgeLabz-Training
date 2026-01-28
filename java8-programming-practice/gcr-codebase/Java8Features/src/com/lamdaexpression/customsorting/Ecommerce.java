package com.lamdaexpression.customsorting;

import java.util.Arrays;
import java.util.List;

public class Ecommerce {	
	
	public static void main(String[] args) {
		
		List<Product>products=Arrays.asList(
                new Product("Laptop", 60000, 4.5, 10),
                new Product("Phone", 30000, 4.7, 15),
                new Product("Headphones", 2000, 4.2, 30),
                new Product("Smart Watch", 15000, 4.4, 20)
        );
		
		products.sort((p1,p2)->Double.compare(p1.getPrice(),p2.getPrice()));
	
		products.sort((p1,p2)->Double.compare(p2.getDiscount(),p1.getDiscount()));
		
		products.sort((p1,p2)->Double.compare(p2.getRating(),p1.getRating()));
	
		products.forEach(System.out::println);
	}
}
