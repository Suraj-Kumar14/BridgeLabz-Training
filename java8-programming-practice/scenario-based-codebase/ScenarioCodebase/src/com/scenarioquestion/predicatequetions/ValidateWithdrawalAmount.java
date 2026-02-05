package com.scenarioquestion.predicatequetions;

import java.util.Scanner;
import java.util.function.Predicate;

public class ValidateWithdrawalAmount {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter amount: ");
		double amount=sc.nextDouble();
		
	//	System.out.println(((Predicate<Double>)a->a>0).test(amount)?"Valid amount to withdraw":"Withdrawal amount is not valid");
		
		Predicate<Double>check=a->a>0;
		if(check.test(amount)) {
			System.out.println("Valid amount to withdraw!");
		}else {
			System.out.println("Withdrawal amount is not valid!");
			
		}
	}

}
