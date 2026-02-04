package com.librarymanagementsystem;

public class LibraryApp {

	public static void main(String[] args) {
		
		LibraryCatalog catalog=LibraryCatalog.getInstance();
		
		User student=UserFactory.createUser("student","Alice");
		User faculty=UserFactory.createUser("faculty", "Dr.Bob");
		
		
		catalog.addObserver(student);
		catalog.addObserver(faculty);
		
		//Builder
		Book book=new Book.BookBuilder("Design patterns")
							.author("GoF")
							.edition("2nd")
							.genre("Software Engineering")
							.build();
		
			//Adding book triggers notification
		catalog.addBook(book);			
	}

	
}
