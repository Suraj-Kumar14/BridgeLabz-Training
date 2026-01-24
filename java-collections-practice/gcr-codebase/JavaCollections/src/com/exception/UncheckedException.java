package com.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter 2 no: ");
		try {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=a/b;
			System.out.println("Number: "+c);
			
		}catch(ArithmeticException e) {
			System.out.println("\nerror :number cannot be divide by zero!");
		}
	
		catch(InputMismatchException  e) {
			System.out.println("\nerror :Please enter number!");
		
		}
	}
		
	

}
