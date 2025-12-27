package com.constructor.Level1;

public class PostgraduateStudent extends Student {
	
	//constructor 
	public PostgraduateStudent(int rollNumber,String name,double CGPA) {
		super(rollNumber,name,CGPA);
	}
	
	//Method demonstrating access to protected member
	public void displayDetails() {
		//public
		System.out.println("Roll Number: "+rollNumber); 
		//protected
		System.out.println("Name: "+name);
		//private via public method
		System.out.println("CGPA: "+getCGPA());
	}
}
