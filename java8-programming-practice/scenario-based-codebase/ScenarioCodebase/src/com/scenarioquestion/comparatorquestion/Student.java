package com.scenarioquestion.comparatorquestion;

public class Student {
	private String name;
	private int rank;
	
	public Student(String name, int rank) {
		super();
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + "]";
	}
	
}
