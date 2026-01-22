package com.binarysearchtree.universitydigitalrecord;

public class Student {
	private String name;
	private int rollNo;
	Student left,right;
	
	public Student(String name, int rollNo) {
		this.name = name;
		this.setRollNo(rollNo);
		left=right=null;
	}
	
	public int getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	
}
