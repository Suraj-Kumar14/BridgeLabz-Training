package com.AmbulanceRoute;

import java.util.Scanner;

public class simulatePatient {
		
	public static void main(String [] args) {
		//Create a Scanner object
		Scanner sc=new Scanner(System.in);
		
		AmbulanceRoute route=new AmbulanceRoute();
		
		System.out.println("-----Ambulance Route Simulation-----");
		System.out.print("Enter number of hospital units: ");
		int n=sc.nextInt();
		sc.nextLine();
		
		//input hospital units
		for(int i=0;i<n;i++) {
			System.out.print("Enter "+(i+1)+" unit name: ");
			String name=sc.nextLine();
			System.out.print("Is "+name+" available? (true/false): ");
			boolean available =sc.nextBoolean();
			sc.nextLine();
			route.addUnit(name, available);
		}
		
		int choice;
		do {
			System.out.println("\n----Menu-----");
			System.out.println("1. Display Route");
			System.out.println("2. Find Available Unit");
			System.out.println("3. Remove Unit (Maintance)");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) 
			{
				case 1:
					route.displayRoute();
					break;
					
				case 2:
					route.findAvailable();
					break;
					
				case 3:
					System.out.print("Enter unit name to remove: ");
					String removeName=sc.nextLine();
					route.removeUnit(removeName);
					break;
					
				case 4:
					System.out.println("Exiting simulation...");
					break;
					
				default:
					System.out.println("Invalid choice!");
			}
		}while(choice!=4);
		sc.close();
	}
}
