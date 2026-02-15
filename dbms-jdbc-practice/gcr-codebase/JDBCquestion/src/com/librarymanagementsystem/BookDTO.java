package com.librarymanagementsystem;

public class BookDTO {
	private int bookId;
	private String bookTitle;
	private String author;
	private String category;
	private int total_copies;
	private int aviable_copies;
	
	public BookDTO(String bookTitle, String author, String category, int total_copies, int aviable_copies) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.category = category;
		this.total_copies = total_copies;
		this.aviable_copies = aviable_copies;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public String getCategory() {
		return category;
	}

	public int getTotal_copies() {
		return total_copies;
	}

	public int getAviable_copies() {
		return aviable_copies;
	}

	public void setBookId(int id) {
		this.bookId=id;		
	}
	
	
}
