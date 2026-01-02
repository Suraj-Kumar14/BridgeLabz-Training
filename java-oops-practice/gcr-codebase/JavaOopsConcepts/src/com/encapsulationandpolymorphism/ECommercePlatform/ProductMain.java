package com.encapsulationandpolymorphism.ECommercePlatform;
import java.util.ArrayList;
import java.util.List;
public class ProductMain {
		
	public static void calculateFinalPrice(List<Product>products) {
		for(Product product: products) {
			double tax=0;
			if(product instanceof Taxable) {
				tax=((Taxable)product).calculateTax();
			}
			
			double discount=product.calculateDiscount();
			double finalPrice=product.getPrice()+tax-discount;
			
			System.out.println("Product: "+product.getName());
			System.out.println("Base Price: " + product.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-------------------------");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product>products=new ArrayList<>();
		
		products.add(new Electronics(1,"Laptop",60000) );
		products.add(new Clothing(2,"Jacket",3000));
		products.add(new Groceries(3,"Rice",1000));
		
		calculateFinalPrice(products);
		
	}

}
