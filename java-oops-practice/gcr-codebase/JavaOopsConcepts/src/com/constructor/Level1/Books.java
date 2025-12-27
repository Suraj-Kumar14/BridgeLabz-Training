package com.constructor.Level1;

public class Books {
	//public variable
	public String ISBN;
	//protected variable
	protected String title;
	//private Variable
	private String author;
	
	//constructor
	public Books(String ISBN,String title) {
		this.ISBN=ISBN;
		this.title=title;
	}
	
	//public method to get Author name
	public String getAuthor() {
		return author;
	}
	
	//public method to set Author
	public void setAuthor(String author) {
		this.author=author;
	}
}
