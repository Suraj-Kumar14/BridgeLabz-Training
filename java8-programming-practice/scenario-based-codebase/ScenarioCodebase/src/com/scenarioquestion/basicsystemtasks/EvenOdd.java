package com.scenarioquestion.basicsystemtasks;

import java.util.Scanner;
import java.util.function.Predicate;

//3.Use lambda to check if a number is even or odd.

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number: ");
		int num=sc.nextInt();
		
		System.out.println(((Predicate<Integer>)n->n%2==0).test(num)? "Even":"Odd");
	}

}
