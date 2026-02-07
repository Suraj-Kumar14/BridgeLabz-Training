package com.scenarioquestion.supplierquestion;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierQuestion {

	public static void main(String[] args) {
		
		/*
		 * 		1.Generate OTP using Supplier.

				2.Generate random student ID using Supplier.
				
				3.Provide current date and time using Supplier.
				
				4.Provide default welcome message using Supplier.
				
				5.Generate random discount coupon using Supplier.
		 */

		System.out.println("1.Generate OTP using Supplier.");
		System.out.println("-------------------------------------------");
		Random random =new Random();
		Supplier<Integer>otp=()->random.nextInt(9999);
		System.out.println(otp.get());
		
		System.out.println("\n2.Generate random student ID using Supplier.");
		System.out.println("--------------------------------------------");
		Supplier<Integer>studentId=()->random.nextInt(999);
		System.out.println(studentId.get());
		
		System.out.println("\n3.Provide current date and time using Supplier.");
		System.out.println("------------------------------------------------");
		Supplier<LocalDateTime>dateTime=()->LocalDateTime.now();
		System.out.println(dateTime.get());
		
		System.out.println("\n4.Provide default welcome message using Supplier");
		System.out.println("---------------------------------------------------");
		Supplier<String>defaultMes=()->"Welcome to java programming";
		System.out.println(defaultMes.get());
		
		System.out.println("\n5.Generate random discount coupon using Supplier.");
		System.out.println("----------------------------------------------------");
		Supplier<Integer>discount=()->random.nextInt(9999);
		System.out.println(discount.get());
	}

}
