package com.scenarioquestion.predicatequetions;

import java.util.Scanner;
import java.util.function.Predicate;

//1.In a student system, use a Predicate to check if a student is eligible for exam (attendance ≥ 75%).
public class ExamEligible {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter percentage: ");
		int per=sc.nextInt();
		
		System.out.println(((Predicate<Integer>)p->p>=75).test(per)?"Eligible":"Not eligible");
	}

}
