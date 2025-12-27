package com.constructor.Level1;

public class CarRentalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarRental car1=new CarRental("Amit","HondaCity",2);
		car1.displayCarRentalDetails();
		car1.calculateTotalCost();
		
		CarRental car2=new CarRental("Aadarsh","Aura",1);
		car2.displayCarRentalDetails();
		car2.calculateTotalCost();

	}

}
