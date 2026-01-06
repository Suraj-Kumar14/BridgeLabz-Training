package com.linkedlist.doublylinkedlist.libraryManagement;

public class Book {
	public String bookTitle;
	public String author;
	public int genreation;
	public int bookID;
	public boolean availability;
	Book prev;
	Book next;
	
	
	public Book(String bookTitle, String author, int genreation, int bookID, boolean availability) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.genreation = genreation;
		this.bookID = bookID;
		this.availability = availability;
		this.prev = null;
		this.next = null;
	}
}