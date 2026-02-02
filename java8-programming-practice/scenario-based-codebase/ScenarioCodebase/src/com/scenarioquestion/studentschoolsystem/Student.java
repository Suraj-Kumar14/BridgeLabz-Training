package com.scenarioquestion.studentschoolsystem;

public class Student {
	private String name;
	private int age;
	private int rank;
	private int marks;
	
	public Student(String name,int age,int rank,int marks) {
		super();
		this.name = name;
		this.age = age;
		this.rank = rank;
		this.marks=marks;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getRank() {
		return rank;
	}
	
	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", rank=" + rank + ", marks=" + marks + "]";
	}
	
}
