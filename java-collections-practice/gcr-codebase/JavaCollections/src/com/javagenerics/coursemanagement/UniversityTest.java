package com.javagenerics.coursemanagement;

import java.util.Arrays;
import java.util.List;

public class UniversityTest {
	public static void main(String[] args) {
		
		Course<ExamCourse>c1=new Course<>("Data Structure","CSE",new ExamCourse());
		Course<AssignmentCourse> c2 =new Course<>("Software Engineering", "IT", new AssignmentCourse());

	    Course<ResearchCourse> c3 =new Course<>("AI Research", "CSE", new ResearchCourse());

	        System.out.println(c1);
	        System.out.println(c2);
	        System.out.println(c3);

	        List<CourseType> allTypes = Arrays.asList(
	            new ExamCourse(),
	            new AssignmentCourse(),
	            new ResearchCourse()
	        );
	        System.out.println("\nAvailable Course Types:");
	        CourseUtil.displayCourse(allTypes);
	}
}
