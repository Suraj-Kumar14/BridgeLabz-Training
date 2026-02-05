package com.scenarioquestion.basicsystemtasks;

import java.util.Scanner;
import java.util.function.BiFunction;

//4.Use lambda to add two numbers.
public class AddTwoNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two number: ");
		int first=sc.nextInt();
		int second=sc.nextInt();
		
		System.out.println(((BiFunction<Integer,Integer,Integer>)(a,b)->a+b).apply(first, second));
	}

}
