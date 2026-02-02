package com.collectors.librarybooksstatistics;

public class Book {
	private String genre;
	private int pages;
	
	public Book(String genre, int pages) {
		super();
		this.genre = genre;
		this.pages = pages;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getPages() {
		return pages;
	}
	
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", pages=" + pages + "]";
	}
	
	
}
