package com.classandobject.Level2;

public class StudentReport {
	//Declaring variables
	String name;
	String rollNumber;
	double []marks;
	
	//Constructor
	StudentReport(String name,String rollNumber,double[] marks){
		this.name=name;
		this.rollNumber=rollNumber;
		this.marks=marks;
	}
	
	//Creating method to calculate grade
	public String calculateGrade(double[] marks) {
		//variable to store the totalMarks
		double totalMarks=calculateTotalMarks(marks);
		
		//to check grade of student
		if(totalMarks>=80 && totalMarks<=100) {
			return "Grade A";
		}else if(totalMarks>=60 && totalMarks<80) {
			return "Grade B";
		}
		else if(totalMarks>=50 && totalMarks<60) {
			return "Grade C";
		}else if(totalMarks>=40 && totalMarks<50) {
			return "Grade D";
		}else {
			return "Grade F";
		}		
	}
	
	//method to display student display
	public void displayStudent() {
		System.out.println("Student Name: "+name);
		System.out.println("Student RollNumber: "+rollNumber);
		for(int i=0;i<marks.length;i++) {
			System.out.println("Marks "+(i+1) +": "+marks[i]);
		}
		System.out.println(calculateGrade(marks));
		System.out.println("----------------");
	}
	
	//method to calculate total Marks
	public double calculateTotalMarks(double[] marks) {
		double sum=0;
		for(int i=0;i<marks.length;i++) {
			sum+=marks[i];
		}
		return sum/3;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] marks1= {80,70,75};
		double[] marks2= {60,65,50};
		
		//Object Creating for constructor invoke
		StudentReport student1=new StudentReport("Thamarai","ECE01",marks1);
		StudentReport student2=new StudentReport("Kannan","CSC002",marks2);
		
		//calling the display method
		student1.displayStudent();
		student2.displayStudent();
	}

}
