package com.scenarioquestion.functionquestion;

import java.util.Scanner;
import java.util.function.Function;

public class CalculateAnnualSalary {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter monthly salary: ");
		double salary=sc.nextDouble();
		
		Function<Double,Double> annual = sal->sal*12;
		
		System.out.println(annual.apply(salary));
	}

}
