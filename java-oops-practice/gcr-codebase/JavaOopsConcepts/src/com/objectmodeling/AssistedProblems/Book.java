package com.objectmodeling.AssistedProblems;

public class Book {
	private String title;
	private String author;
	
	//constructor
	public Book(String title,String author) {
		this.title=title;
		this.author=author;
	}
	
	//display the book details
	public void displayBookDetails() {
		System.out.println("\n--------Book Details-------");
		System.out.println("Book title: "+title);
		System.out.println("Author Name: "+author);
		System.out.println("-----------------------------");
	}
}
