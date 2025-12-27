package com.constructor.Level1;

public class CarRental {
	//attributes
	private String customerName;
	private String carModel;
	private int rentalDays;
	
	//constructor to initialize the rental details
	CarRental(String customerName,String carModel,int rentalDays){
		this.customerName=customerName;
		this.carModel=carModel;
		this.rentalDays=rentalDays;
	}
	
	//Calculate totalCost
	public void calculateTotalCost() {
		if(carModel=="HondaCity") {
			System.out.println("Total rent: "+rentalDays*2000);
		}
		else if(carModel=="Aura") {
			System.out.println("Total rent: "+rentalDays*1800);

		}
		else {
			System.out.println("This model is currently not available.");
		}
		System.out.println();
	}
	
	//display car rental details
	public void displayCarRentalDetails() {
		System.out.println("Customer Name: "+customerName);
		System.out.println("Car Model: "+carModel);
		System.out.println("Rental Days: "+rentalDays);
	}
	
}
