package com.constructor.Level1;

public class CourseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course course1=new Course("Java",6,4500.0);//invoke constructor
		
		//call method displayCourseDetails
		course1.displayCourseDetails();
		
		//call class method updateInstituteName
		Course.updateInstituteName("Sharma Computer Academy");
		course1.displayCourseDetails();	
	}

}
