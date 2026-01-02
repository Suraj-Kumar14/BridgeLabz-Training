package com.VehicleRentalSystem;

public class VehicleRentalApp {
	public static void main(String [] args) {
		 Customer c1=new Customer(1,"Rahul");		 
		 Vehicle v1=new Bike("B101","Yamaha",300);
		 v1.displayInfo();
		 c1.displayCustomer();
		 System.out.println("Rent for 3 days: ₹" + v1.calculateRent(3));
		 System.out.println();
		
		 
		 Customer c2=new Customer(2,"Akhshay");	
		 Vehicle v2=new Car("C201","HondaCity",1500);
		 v2.displayInfo();
		 c2.displayCustomer();
		 System.out.println("Rent for 3 days: ₹" + v2.calculateRent(2));
		 System.out.println();
		 
		 Customer c3=new Customer(3,"Varun");	
		 Vehicle v3=new Truck("T301","Tata",2500);
		 v3.displayInfo();
		 c3.displayCustomer();
		 System.out.println("Rent for 3 days: ₹" + v3.calculateRent(5));
		
		 
	}
}
