package com.constructor.Level1;

public class Course {
	
	//Instance variable
	private String courseName;
	private int duration;
	private double fee;
	
	//class variable (common for all courses)
	private static String instituteName = "TechnoCrats Institute";
	
	//constructor
	public Course(String courseName,int duration,double fee) {
		this.courseName=courseName;
		this.duration=duration;
		this.fee=fee;		
	}
	
	//Instance method to display course details
	public void displayCourseDetails() {
		System.out.println("Course name: "+courseName);
		System.out.println("Duration: "+duration+" months");
		System.out.println("Total fee $: "+fee);
		System.out.println("Institute name: "+instituteName);
		System.out.println();
	}
	
	//class method to update institute name
	public static void updateInstituteName(String newInstituteName) {
		instituteName=newInstituteName;
		
	}
}
