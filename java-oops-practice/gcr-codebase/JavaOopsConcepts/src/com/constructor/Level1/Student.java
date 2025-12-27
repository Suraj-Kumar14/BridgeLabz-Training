package com.constructor.Level1;

public class Student {
    //public variable
	public int rollNumber;
	//protected variable
	protected String name;
	//private variable
	private double CGPA;
	
	//constructor
	public Student(int rollNumber,String name,double CGPA) {
		this.rollNumber=rollNumber;
		this.name=name;
		this.CGPA=CGPA;
	}
	
	//public method to access CGPA
	public double getCGPA() {
		return CGPA;
	}
	
	//public method to modify CGPA
	public void setCGPA(double CGPA) {
		this.CGPA=CGPA;
	}	
}
