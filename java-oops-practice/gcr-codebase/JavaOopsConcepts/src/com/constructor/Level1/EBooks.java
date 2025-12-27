package com.constructor.Level1;

public class EBooks extends Books {
	public EBooks(String ISBN,String title) {
		super(ISBN,title);
	}
	
	//method to display book details
	public void displayBookDetails() {
		System.out.println("The ISBN no of Book: "+ISBN);
		System.out.println("The Title of Book: "+title);
		System.out.println("The Author of Book: "+getAuthor());
	}
}
