package com.inheritance.Multilevelinheritance.EducationalCourseHierarchy;

public class Course {
	protected String courseName;
	protected int duration;
	
	//constructor
	public Course(String courseName,int duration) {
		this.courseName=courseName;
		this.duration=duration;
	}
	
	public void getCourseInfo() {
		System.out.println("Course: "+courseName);
		System.out.println("Duration: "+duration+" months");
	}
}
