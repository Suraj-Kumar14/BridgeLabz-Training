package com.examproctor;

public class Main {
	
	public static void main(String[] args) {
		Questions question1=new Questions(101,"Q1: Which keyword is used to implement an interface?\nA. extends\nB. implements\nC. inherits\nD. uses");
		Questions question2=new Questions(102,"Q2: What does method overloading demonstrate?\nA. Runtime Ploymorphism\nB. Complie-time Polymorphism\nC. Encapsulation\nD. Inheritance");
		Questions question3=new Questions(103,"Q3: Which concept combines data and methods into a single unit?\nA. Inheritance\nB. Polymorphism\nC. Encapsulation\nD. Abstraction");
		Questions question4=new Questions(104,"Q4: How many primitive data types are in Java?\nA. 6\nB. 7\nC. 8\nD. 9");
		Questions question5=new Questions(105,"Q6: What is the default value of a boolean variable?\nA. final\nB. abstract\nC. static\nD. native");
		
		ExamManagement management=new ExamManagement();
		management.questions.push(question1);
		management.questions.push(question2);
		management.questions.push(question3);
		management.questions.push(question4);
		management.questions.push(question5);
		
		management.correctAnswer.put(101,"B");
		management.correctAnswer.put(102,"B");
		management.correctAnswer.put(103,"C");
		management.correctAnswer.put(104,"B");
		management.correctAnswer.put(105,"C");
		
		
		management.exam();
		System.out.println();
		management.showResult();
		
	}
}
