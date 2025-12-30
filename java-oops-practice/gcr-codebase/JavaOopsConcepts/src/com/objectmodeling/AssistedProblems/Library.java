package com.objectmodeling.AssistedProblems;
import java.util.ArrayList;
public class Library {
	private ArrayList<Book> bookList;
	private String libraryName;
	
	//constructor
	public Library(String libraryName) {
		this.libraryName=libraryName;
		this.bookList=new ArrayList<>();
	}
	
	//add book
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	//display book
	public void displayLibraryBook() {
		System.out.println("\n--------Library Book---------");
		System.out.println("Library Name: "+libraryName);
		System.out.println("Book Available");
		for(Book b: bookList) {
			b.displayBookDetails();
		}
	}
}
