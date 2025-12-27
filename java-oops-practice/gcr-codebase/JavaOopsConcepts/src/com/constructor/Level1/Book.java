package com.constructor.Level1;

public class Book {
	private String title;
	private String author;
	private double price;
	
	//Default constructor
	Book(){}
	
	//Parametrized constructor
	Book(String title,String author,double price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	
	//Display bookDetails
	public void bookDeatils() {
		System.out.println("The Title of Book: "+title);
		System.out.println("The Author of Book: "+author);
		System.out.println("The price of Book: "+price);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book=new Book("Wings of fire","A.P.J Abdul kalam",300.0);
		book.bookDeatils();
	}

}
