package com.scenarioquestion.shopping_ecommerce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Product>products=Arrays.asList(new Product("Laptop",65000),
											new Product("Smartphone",25000),
											new Product("Headphones",2500),
											new Product("Smartwatch",8000),
											new Product("Blutooth Speaker",3200),
											new Product("Keyword",1200),
											new Product("Mouse",700),
											new Product("USB",500),
											new Product("PowerBank",1800));
		
		System.out.println("\n1.Use lambda to apply 10% discount on product price.");
		System.out.println("--------------------------------------------------------------------");
		products.stream().forEach(x->System.out.println(x.getName()+" - Price= "+x.getPrice()+" -  Discount: "+x.getPrice()*0.1+" =Final price: "+(x.getPrice()-x.getPrice()*0.1)));
		System.out.println("--------------------------------------------------------------------");
		
		
		System.out.println("\n2.Sort products by price using lambda.");
		System.out.println("--------------------------------------------------------------------");
		products.stream().sorted((p1,p2)->Double.compare(p1.getPrice(),p2.getPrice())).forEach(System.out::println);
		System.out.println("--------------------------------------------------------------------");
		
		
		System.out.println("\n3.Use lambda to check free delivery eligibility (amount > 500).");
		System.out.println("--------------------------------------------------------------------");
		products.stream().forEach(p->System.out.println(p.getPrice()>500 ? p.getName()+" is eligible for free delivery" : p.getName()+" not eligible for free delivery"));
		System.out.println("--------------------------------------------------------------------");
		
		
		System.out.println("\n4.Use lambda to calculate final bill amount.");
		System.out.println("--------------------------------------------------------------------");
		products.stream().forEach(p->System.out.println(p.getName()+" - Price: "+p.getPrice()+" - discount 10%  Final Bill= "+(p.getPrice()-p.getPrice()*0.1)));
		System.out.println("--------------------------------------------------------------------");
		
		
		System.out.println("\n5.Use lambda to print product names.");
		System.out.println("--------------------------------------------------------------------");
		products.stream().forEach(x->System.out.println(x.getName()));
		System.out.println("--------------------------------------------------------------------");
	
	}

}
