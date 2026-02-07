package com.scenarioquestion.functionquestion;

import java.util.Scanner;
import java.util.function.Function;

//1.Convert student marks into grade (A/B/C) using Function.
public class MarksIntoGrade {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter marks: ");
		int marks=sc.nextInt();
		if(marks>100) {
			System.out.println("Marks should not be greater than 100.");
			return;
		}
		
		Function<Integer,Character>grade=(mark->mark>=70?'A':(mark>=40?'B':'C'));
		
//		Function<Integer, Character> gradeCal = (mark) -> {
//			if(mark >= 80) return 'A';
//			else if(mark >= 60) return 'B';
//			else if(mark >= 45) return 'C';
//			else return 'F';
//		}; 
		
		System.out.println(grade.apply(marks));
		
	}

}
