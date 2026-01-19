package com.javagenerics.coursemanagement;

public class AssignmentCourse extends CourseType{

	public AssignmentCourse() {
		super("Assignment and Project");
	}

	@Override
	public String getType() {
		return "Assignment Based";
	}

	
}
