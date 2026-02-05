package com.scenarioquestion.predicatequetions;

import java.util.Scanner;
import java.util.function.Predicate;

public class CheckEvenOdd {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number: ");
		int num=sc.nextInt();

		Predicate<Integer>evenOdd=n->n%2==0;
		
		if(evenOdd.test(num)) {
			System.out.println("Number is even number.");
		}else {
			System.out.println("Number is odd number");
		}
	}

}
