package com.javagenerics.coursemanagement;

public class ResearchCourse extends CourseType{

	public ResearchCourse() {
		super("Research & Thesis");
	}

	@Override
	public String getType() {
		return "Research-Based";
	}

}
