package com.medistore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MediStore {

	public static void main(String[] args) {
		 
		System.out.println("------Welcome to Maa Medical Store------");
		Scanner sc=new Scanner(System.in);
		
		Store store=new Store();
		do
		{
				System.out.println();
				System.out.println("Enter 1 to add Medicine: ");
				System.out.println("Enter 2 to remove Medicine:");
				System.out.println("Enter 3 to sell Medicine:");
				System.out.println("Enter 4 to view all Medicine:");
				System.out.println("Enter 5 to exit:");
				
				int n =sc.nextInt();
				sc.nextLine();
				if(n==1) {
					System.out.print("Enter medicine type: ");
					String type=sc.nextLine();					
					System.out.print("Enter medicine name: ");
					String name=sc.nextLine();
				
					System.out.print("Enter medicine price: ");
					double price=sc.nextDouble();
					sc.nextLine();
					System.out.print("Enter Expiry Date: ");
					DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yy");
					String d=sc.nextLine();
					LocalDate date=LocalDate.parse(d,formatter);
					System.out.print("Enter quantity: ");
					int quantity=sc.nextInt();
					sc.nextLine();
					store.addMedicine(type,name,price,date,quantity);
				}
				else if(n==2) {
						System.out.println("Enter Medicine name: ");
						String name=sc.nextLine();
						store.removeMedicine(name);					
			       	}
				else if(n==3) {
						System.out.print("Enter medicine name: ");
						String name=sc.nextLine();
						System.out.print("Enter Quantity: ");
						int quantity=sc.nextInt();
						store.sell(name, quantity);
				}
				else if(n==4) {
					store.view();
				}
				else {
					System.out.println("Thank you for visiting!");
					break;
				}
					
				}while(true);
		}

}
