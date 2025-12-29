package com.keywordandoperator.Level1;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Set the library name 
	       Book.setLibraryName("Egmore Library");
	       // Display the library name
	       Book.displayLibraryName();
	       // Create a new book instance
	       Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
	       // Display book details
	       book1.displayBookDetails();
	}
}
