package com.scenariobasedonsorting.smartshelf;

public class BookShelf {

	public static void main(String[] args) {
		
	
		BookArrangement book=new BookArrangement();
		book.addBook("Social science");
		book.addBook("Science");
		book.addBook("Godan");
		book.addBook("Wings of fire");
		
		book.displayShelf();
		
		book.insertionSort();
		
		book.displayShelf();

	}

}
