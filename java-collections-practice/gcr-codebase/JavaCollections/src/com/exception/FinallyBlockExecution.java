package com.exception;

import java.util.Scanner;

public class FinallyBlockExecution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter first number: ");
		int a=sc.nextInt();
		System.out.print("Enter first number: ");
		int b=sc.nextInt();
		try {
			int c=a/b;
			System.out.println("Division: "+c);
		}catch(ArithmeticException e) {
			System.out.println("\nError: Integer is not divisible by 0.");
		}
		finally {
			System.out.println("Operation completed.");
		}
	}

}
