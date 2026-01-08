package com.parkEase;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		//here owner can create the parking slot and add in the list of parking slot
		ParkingSlot slot1 = new ParkingSlot(1001,true,"Bike");
		ParkingSlot slot2 = new ParkingSlot(1002,true,"Car");
		ParkingSlot slot3 = new ParkingSlot(1003,true,"Truck");
		ParkingSlot slot4 = new ParkingSlot(1004,true,"Car");
		ParkingSlot slot5 = new ParkingSlot(1005,true,"Truck");
		
		ParkingManagement owner = new ParkingManagement();
		owner.addParkingSlot(slot1);
		owner.addParkingSlot(slot2);
		owner.addParkingSlot(slot3);
		owner.addParkingSlot(slot4);
		owner.addParkingSlot(slot5);
		
		while(true) {
			System.out.println("\n---------------Choose Option--------------");
			System.out.println("For Vehicle Park-> please enter 'P': ");
			System.out.println("For Vehicle Exit-> please enter 'A' : ");
			System.out.println("Remove Product in Cart-> please enter 'R' : ");
			System.out.println("Want to View Cart list-> press 'V' :");
			System.out.println("Want to Check Bill-> press 'B' ");
			System.out.println("Want to Exit-> press 'E' :");
			System.out.println("--------------------------------------------");
			
			char c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			
			if(c=='E'){
				System.out.println("Thanks for use our service! Please come again");
				break;
			}
			
			switch(c) {
				case 'P': //done
					break;
				case 'R':
					//take input - 
					break;
					//take input - 

				case 'V':
					break;
				case 'B':
					break;
				default:
					System.out.println("Invalid input!");
			}
		}
	}
}