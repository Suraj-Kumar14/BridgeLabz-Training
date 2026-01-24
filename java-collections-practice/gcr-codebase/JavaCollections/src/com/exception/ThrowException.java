package com.exception;

import java.util.Scanner;

public class ThrowException {

	public static double calculateInterest(double amount,double rate,int years)throws IllegalArgumentException {
	
		if(amount<0 || rate<0) {
			throw new IllegalArgumentException("Amount and rate must be positive.");
		}
		return (amount*rate*years)/100;
	}
	
	public static void main(String[] args) {
		double amount,rate;
		int years;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Amount: ");
		amount=sc.nextDouble();
		System.out.print("Enter rate: ");
		rate=sc.nextDouble();
		System.out.print("Enter years: ");
		years=sc.nextInt();
		try {
			double result=calculateInterest(amount,rate,years);
			System.out.println("Calculated interest: "+result);
		}catch(IllegalArgumentException e) {
			System.out.println("Invalid input: Amount and rate must be positive.");
		}
	}	

}
