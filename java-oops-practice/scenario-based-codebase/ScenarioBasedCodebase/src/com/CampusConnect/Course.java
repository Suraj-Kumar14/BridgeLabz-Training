package com.CampusConnect;

public class Course implements ICourseAction {
	private boolean enrolled;
     private String name;
     private int id;
	 public Course(String name, int id) {
		this.name = name;
		this.id = id;
	 }
	 public String getName() {
		 return name;
	 }
	 public void setName(String name) {
		 this.name = name;
	 }
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public boolean isEnrolled() {
		return this.enrolled;
	}
	 public void setEnrolled(boolean enrolled) {
		 this.enrolled = enrolled;
	 }
	 @Override
	 public void enrollCourse(String courseName, int courseId) {
		if(isEnrolled()) {
			System.out.println("The person has already enrolled the course");
			return;
		}
		setEnrolled(true);
		System.out.println("SuccessFully enrolled to the course "+getName());
	 }
	 @Override
	 public void dropCourse(int courseId) {
		if(!isEnrolled()) {
			System.out.println("The student has not enrolled yet");
			return;
		}
		setEnrolled(false);
		System.out.println("The student has successfully drop the course "+getName());
	 }
     public void details() {
    	 System.out.println("\n--------Course Detail---------");
    	 System.out.println("Course Name  : "+this.name);
    	 System.out.println("Course Id    : "+this.id);
    	 System.out.println("Enrolled     : "+this.enrolled);
     }
     
}