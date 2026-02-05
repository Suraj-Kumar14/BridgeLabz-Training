package com.scenarioquestion.basicsystemtasks;
//5.Use lambda to find greater of two numbers.

import java.util.Scanner;
import java.util.function.BiPredicate;

public class FindGreater {

	public static void main(String[] args) {		

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two number: ");
		int first=sc.nextInt();
		int second=sc.nextInt();
		
		System.out.println(((BiPredicate<Integer,Integer>)(a,b)->a>b).test(first,second)?first+" is greater":second+" is greater");
	}

}
