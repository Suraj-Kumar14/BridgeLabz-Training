package com.constructor.Level1;

public class LibraryBookSystemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibraryBookSystem book=new LibraryBookSystem("Arthashastra","Chanakya",300.0);
		book.displayBookDetails();
		book.borrowBook();
		book.displayBookDetails();
		book.borrowBook();
		
	}

}
