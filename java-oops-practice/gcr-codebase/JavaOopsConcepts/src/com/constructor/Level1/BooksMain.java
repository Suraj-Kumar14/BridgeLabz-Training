package com.constructor.Level1;

public class BooksMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EBooks book=new EBooks("978-8173711466","Wings of Fire");
		//call setter method
		book.setAuthor("A.P.J. Abdul Kalam");
		//call getter method
		book.getAuthor();
		//call method displayBookDetails
		book.displayBookDetails();		
	}
}
