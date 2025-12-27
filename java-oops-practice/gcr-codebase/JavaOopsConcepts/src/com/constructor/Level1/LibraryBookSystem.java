package com.constructor.Level1;

public class LibraryBookSystem {
	//attributes
	private String title;
	private String author;
	private double price;
	private boolean isAvailability=true;
	
	//constructor
	public LibraryBookSystem(String title, String author,double price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}
	
	//Method borrow book
	public void borrowBook() {
		if(isAvailability) {
			System.out.println("You hava successfully borrow \""+title+"\".");
			isAvailability=false;
		}
		else {
			System.out.println("Sorry, "+title +" is currently not available.");
		}
	}
	
	//method to display book details
	public void displayBookDetails() {
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("price: "+price);
		System.out.println("Availability: "+(isAvailability ? "Available":"not available"));
	}
}
