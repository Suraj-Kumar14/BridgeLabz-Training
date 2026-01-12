package com.CallCenter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		CallManagement call=new CallManagement();			
		int choice;
		
		do {
			System.out.println("\n------Welcome to Call Center------");
			System.out.println("1. Add customer details.");
			System.out.println("2. View customer details.");
			System.out.println("3. Exit.");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(choice) 
			{
				case 1:
					System.out.print("Enter name: ");
					String name=sc.nextLine();
					System.out.print("Enter phone number: ");
					String phoneNo=sc.nextLine();
					Customer customer=new Customer(name,phoneNo);
					call.addCustomer(customer);
					break;
					
				case 2:
					call.showCustomerData();
					break;
				
				case 3:
					System.out.println("Exit!");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}while(choice!=3);
		sc.close();
	}

}
