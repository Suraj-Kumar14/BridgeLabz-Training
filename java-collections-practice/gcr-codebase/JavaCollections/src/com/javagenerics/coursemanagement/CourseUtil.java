package com.javagenerics.coursemanagement;

import java.util.List;

public class CourseUtil {
	public static void displayCourse(List<? extends CourseType>course) {
		for(var ct: course) {
			System.out.println("Course Type: "+ct.getType()+", Evaluation: "+ct.getEvaluationMethod());
			
		}
	}
}
