package com.scenarioquestion.predicatequetions;

import java.util.Scanner;
import java.util.function.Predicate;

public class OrderEligible {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter OrderPrice: ");
		double price=sc.nextDouble();

		System.out.println(((Predicate<Double>)p->p>499).test(price)?"Eligible for free delivery":"Not eligble for free delivery");
	}

}
