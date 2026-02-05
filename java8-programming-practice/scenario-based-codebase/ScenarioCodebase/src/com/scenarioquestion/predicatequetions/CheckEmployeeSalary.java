package com.scenarioquestion.predicatequetions;

import java.util.Scanner;
import java.util.function.Predicate;

//2.In an employee system, check if salary is greater than 30,000 using Predicate.

public class CheckEmployeeSalary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter salary: ");
		double salary=sc.nextDouble();
		
		System.out.println(((Predicate<Double>)s->s>30000).test(salary)?"Salary is greater than 30000":"Salary is not greater than 30000");
	}

}
