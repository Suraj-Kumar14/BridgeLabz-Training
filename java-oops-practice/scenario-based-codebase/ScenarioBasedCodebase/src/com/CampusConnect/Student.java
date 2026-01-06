package com.CampusConnect;
import java.util.ArrayList;

public class Student extends Person {
    ArrayList<Course> course = new ArrayList<>();
	public Student(long id, String name, String email) {
		super(id, name, email);
		// TODO Auto-generated constructor stub
	}
    public void addCourse(String courseName,int courseId) {
    	course.add(new Course(courseName,courseId));
    	System.out.println("SuccessFully added the course");
    }
    public void eroll(int id) {
	   
       for(Course c:course) {
    	   if(c.getId()==id) {
    		   c.enrollCourse(c.getName(), c.getId());
    		   return;
    	   }	   
       }
       System.out.println("The course not found");
	}
    public void drop(int id) {
    	  for(Course c:course) {
       	   if(c.getId()==id) {
       		   c.dropCourse(c.getId());
       		   return;
       	   }	   
          }
          System.out.println("The course not found");
    }
    public void details() {
    	System.out.println("\n-----------Student Details------------");
    	System.out.println("Student name : "+getName());
    	System.out.println("Student Id   : "+getId());
    	System.out.println("Student email: "+getEmail());
    	
    	for(Course c: course) {
    		c.details();
    	}
    }
}