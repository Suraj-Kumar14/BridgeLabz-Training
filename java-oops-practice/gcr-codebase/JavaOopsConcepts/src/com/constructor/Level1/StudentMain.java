package com.constructor.Level1;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostgraduateStudent pg=new PostgraduateStudent(101,"Suraj",8.7);
		pg.displayDetails();
		
		//modify CGPA using public method
		pg.setCGPA(9.0);
		System.out.println("Updated CGPA: "+pg.getCGPA());
	}

}
