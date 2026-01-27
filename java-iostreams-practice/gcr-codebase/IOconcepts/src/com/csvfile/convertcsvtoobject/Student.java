package com.csvfile.convertcsvtoobject;

public class Student {
	
	 int id;
	    String name;
	    String branch;
	    int marks;

	    public Student(int id, String name, String branch, int marks) {
	        this.id = id;
	        this.name = name;
	        this.branch = branch;
	        this.marks = marks;
	    }

	    @Override
	    public String toString() {
	        return "Student [ID=" + id +
	               ", Name=" + name +
	               ", Branch=" + branch +
	               ", Marks=" + marks + "]";
	    }
}
