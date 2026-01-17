package com.smartlibrary;

public class Book {
	private String name;
	private int id;
	public Book(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Book name: "+name+" || Book ID: "+id;
	}
}
