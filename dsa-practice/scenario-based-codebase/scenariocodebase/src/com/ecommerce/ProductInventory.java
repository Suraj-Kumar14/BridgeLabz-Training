package com.ecommerce;

import java.util.Scanner;

public class ProductInventory {

	public static void main(String[] args) {
		
		ECommerce product=new ECommerce();
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("\n-------E-Commerce Product Inventory-------");
			System.out.println("1. Insert product.\n2. Lookup product.\n3. Price update.\n4. Dispaly all product.\n5. Exit.");
			System.out.print("Enter choice: ");
			int choice=sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Enter SKU number: ");
					int number=sc.nextInt();
					System.out.print("Enter Price: ");
					double price=sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter name ");
					String name=sc.nextLine();
					product.root=product.insertProduct(product.root,number, price, name);
					break;
					
				case 2:
					System.out.print("Enter SKU number: ");
					int number2=sc.nextInt();
					product.search(product.root,number2);
					break;
					
				case 3:
					System.out.print("Enter SKU number: ");
					int number3=sc.nextInt();
					System.out.print("Enter new price: ");
					price=sc.nextDouble();
					product.updateProduct(product.root, number3, price);
					break;
					
				case 4:
					product.inorder(product.root);;
					break;
					
				case 5:
					System.out.println("Exiting..");
					sc.close();
					System.exit(0);
					
				default: 
					System.out.println("Invalid choice!");
			}
		}
	}

}
