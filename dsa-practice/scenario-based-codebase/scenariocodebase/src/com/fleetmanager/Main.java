package com.fleetmanager;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		FleetManager manager = new FleetManager();
		
		
		System.out.println("------------------- FleetManager-------------------\n");
		
		String id,name;
		int choice, mileage;
		while(true) {
			System.out.println("Enter 1 to view all vehicle details");
			System.out.println("Enter 2 to add a vehicle");
			System.out.println("Enter 3 to sort vehicles");
			System.out.println("Enter 4 to exit");
			
			// try catch block for valid choice
			try {
				System.out.print("Enter choice: ");
				choice = sc.nextInt();
				sc.nextLine();
			} catch(Exception e) {
				System.out.println("Please choose a valid option");
				sc.nextLine();
				continue;
			}
			
					
			// Perform operation based on choice
			switch(choice) {
				case 1:
					manager.showVehicleDetails();
					break;
					
				case 2:
					System.out.println("Enter vehicle name:");
					name=sc.nextLine();
					System.out.println("Enter Vehicle Number: ");
					 id= sc.nextLine();
		
					while(true) {
						try {
							System.out.println("Enter mileage: ");
							mileage = sc.nextInt();
							sc.nextLine();
							break;
						} catch(Exception e) {
							System.out.println("Please enter numeric mileage");
							sc.nextLine();
							continue;
						}
					}
					
					manager.addVehicle(new Vehicle(name,id, mileage));
					break;
					
				case 3:
					manager.sortVehicle();
					break;
					
				case 4:
					System.out.println("Thank you");
					return;
					
				default:
					System.out.println("Please enter a valid choice");
			}
		}
	}
}