package com.examproctor;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ExamManagement {
	
	static Stack<Questions>questions=new Stack<>();
	
	static HashMap<Integer,String>correctAnswer=new HashMap<>();
	
	static HashMap<Integer,String>userAnswer=new HashMap<>();
	
	Scanner sc=new Scanner(System.in);
	
	int correct=0;
	public void exam() {
	for(Questions ques: questions) {
		System.out.println(ques);
		System.out.print("Enter answer: ");
		String answer=sc.nextLine();
		userAnswer.put(ques.quesId, answer);
		if(correctAnswer.get(ques.quesId).equalsIgnoreCase(userAnswer.get(ques.quesId))) {
			correct++;
		}
		System.out.println();
	   }
	}
	
	public void showResult() {
		System.out.println("Correct answer: "+correct);
	}
}
