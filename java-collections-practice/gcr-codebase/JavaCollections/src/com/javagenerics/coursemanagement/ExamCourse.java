package com.javagenerics.coursemanagement;

public class ExamCourse extends CourseType{

	public ExamCourse() {
		super("Written Examination");
	}

	@Override
	public String getType() {
		return "Exam based";
	}
	
}
