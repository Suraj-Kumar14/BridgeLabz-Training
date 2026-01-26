package com.reflectionandannotations.reflection.dynamicallycreateobject;

public class Student {
	private String name;
	
	public Student(String name) {
		this.name=name;
	}
	
	public void show() {
		System.out.println(name);
	}
}
