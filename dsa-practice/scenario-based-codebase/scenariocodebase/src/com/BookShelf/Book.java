package com.BookShelf;


public class Book {
	private String title;
	private String author;
	protected boolean isBorrowed;
	
	public Book(String title, String author) {
		this.title=title;
		this.author=author;
		this.isBorrowed=false;
	}

	public String toString() {
		String status=isBorrowed ?"(Borrowed)": "(Available)";
		return title+" by "+author;
	}
	
	public String getTitle() {
		return title;
	}
	
}
