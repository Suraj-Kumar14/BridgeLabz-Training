package com.CampusConnect;
import java.util.ArrayList;

public class Teacher extends Person{
    ArrayList<Student> student = new ArrayList<>();
	public Teacher(long id, String name, String email) {
		super(id, name, email);
		// TODO Auto-generated constructor stub
	}
	
	public void  addStudent(int id,String name,String email) {
		Student stu = new Student(id,name,email);
		student.add(stu);
	}
	
	public void addCourse(int studentId,String courseName,int id) {
		for(Student s: student) {
    		if(s.getId()==studentId) {
    		   s.addCourse(courseName, id);
    		}
    	}
    	System.out.println("Student not found");
	}
    public void enroll(int studentId,int courseId) {
    	for(Student s: student) {
    		if(s.getId()==studentId) {
    			s.eroll(courseId);
    		}
    	}
    	System.out.println("Student not found");
    }
    public void drop(int studentId,int courseId) {
    	for(Student s: student) {
    		if(s.getId()==studentId) {
    			s.drop(courseId);
    		}
    	}
    	System.out.println("Student not found");
    }
    public void details() {
    	System.out.println("\n---------Teacher Details----------");
    	System.out.println("Teacher Name  : "+getName());
    	System.out.println("Teacher Id    : "+getId());
    	System.out.println("Teacher Email : "+getEmail());
    	for(Student s: student) {
    		s.details();
    	}
    }
}