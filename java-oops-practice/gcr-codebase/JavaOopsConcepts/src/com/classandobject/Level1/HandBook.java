package com.classandobject.Level1;

public class HandBook {
	private String bookTitle;
	private String authorName;
	private double price;
	
	//Constructor
	HandBook(String bookTitle,String authorName,double price){
		this.bookTitle=bookTitle;
		this.authorName=authorName;
		this.price=price;
	}
	
	// method to display details
	public void displayBookDetails() {
		System.out.println("Title of the Book: "+bookTitle);
		System.out.println("Author of the Book: "+authorName);
		System.out.println("Price of the Book: "+price);
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandBook book1=new HandBook("2States","Chetan Bhagat",500);
		HandBook book2=new HandBook("Wings Of FIre","Abdul Kalam.A.P.J",500);
		book1.displayBookDetails();
		book2.displayBookDetails();
	}

}
