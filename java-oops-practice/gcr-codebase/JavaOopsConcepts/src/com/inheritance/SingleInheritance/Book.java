package com.inheritance.SingleInheritance;

public class Book {
	public String title;
	public int publicationYear;
	
	//constructor
	public Book(String title,int publicationYear) {
		this.title=title;
		this.publicationYear=publicationYear;		
	}
	
	public void displayInfo() {
		System.out.println("Book title: "+title);
		System.out.println("Book Publication Year: "+publicationYear);
	}
}
