package com.exception.customexception;

import java.util.Scanner;

public class Age {

	public static void validateAge(int age) throws InvalidAgeException {
		if(age>=18) {
			System.out.println("Access granted!");
		}
		else {
			throw new InvalidAgeException("Age must should be 18 or greater.");
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter age: ");
		int age=sc.nextInt();
		
		try {
			validateAge(age);
		}
		catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}
	}

}
