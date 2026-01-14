package com.smartcheckout;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Item item1=new Item("Biscuit",101,10,10);
		Item item2=new Item("Rice",102,255,8);
		Item item3=new Item("Ashirwad wheat flour",103,245,10);
		Item item4=new Item("Coconut oil",104,65,5);
		Item item5=new Item("Red Chilli",105,75,10);
		Item item6=new Item("Turmeric powder",106,45,9);
		Item item7=new Item("Allu",107,20,50);
		Item item8=new Item("Mixture",108,103,6);
		Item item9=new Item("Dove Shampoo",109,2,15);
		Item item=new Item("Cream",111,54,10);
		
		Supermarket market=new Supermarket();
		market.addItem(item1);
		market.addItem(item2);
		market.addItem(item3);
		market.addItem(item4);
		market.addItem(item5);
		market.addItem(item6);
		market.addItem(item7);
		market.addItem(item8);
		market.addItem(item9);
		market.addItem(item);
		
		
		int choice;
		do {
			market.show();
			System.out.println("\n---------Welcome to Supermarket----------");
			System.out.println("1. Add customer.");
			System.out.println("2. Show price.");
			System.out.println("3. Purchase item.");
			System.out.println("4. Show Customer.");
			System.out.println("5. Exit.");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
				case 1:
					System.out.print("Enter Customer name: ");
					String name=sc.nextLine();
					System.out.print("Enter Mobile no: ");
					String mobNo=sc.nextLine();
					Customer customer =new Customer(name,mobNo);
					market.addCustomer(customer);
					break;
					
				case 2:
					System.out.print("Enter product Id: ");
					int id=sc.nextInt();
					market.showPrice(id);
					break;
					
				case 3:
					System.out.print("Enter itemId: ");
					int ids=sc.nextInt();
					System.out.print("Enter quantity: ");
					int quan=sc.nextInt();
					market.purchase(ids, quan);
					break;
					
				case 4: 
					market.showCustomer();
					break;
					
				case 5:			
					System.out.println("Exiting program!");
					break;
					
				default:
					System.out.println("Invalid choice!");
			}
			
		}while(choice!=5);
	}
}
