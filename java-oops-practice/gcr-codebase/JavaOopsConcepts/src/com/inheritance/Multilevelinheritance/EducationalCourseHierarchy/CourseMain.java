package com.inheritance.Multilevelinheritance.EducationalCourseHierarchy;

public class CourseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course course=new Course("Mathematics",12);
		course.getCourseInfo();
		
		System.out.println("--------------------");
		OnlineCourse onlineCourse=new OnlineCourse("Java Programming",8,"Udemy",true);
		onlineCourse.getCourseInfo();
		
		System.out.println("---------------------");
		PaidOnlineCourse paidOnlineCourse=new PaidOnlineCourse("Data Science Bootcamp",10,"Coursera",true,5000.0,10.0);
		paidOnlineCourse.getCourseInfo();
	}

}
