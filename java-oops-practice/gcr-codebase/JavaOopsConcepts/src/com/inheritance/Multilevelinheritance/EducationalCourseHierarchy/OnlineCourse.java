package com.inheritance.Multilevelinheritance.EducationalCourseHierarchy;

public class OnlineCourse extends Course {
	protected String platform;
	protected boolean isRecorded;
	
	//constructor
	public OnlineCourse(String courseName,int duration,String platform,boolean IsRecorded) {
		super(courseName,duration);
		this.platform=platform;
		this.isRecorded=isRecorded;
	}
	
	@Override
	public void getCourseInfo() {
		super.getCourseInfo();
		System.out.println("Platform: "+platform);
		System.out.println("isRecorded: "+isRecorded);
	}
}
