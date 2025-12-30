package com.objectmodeling.AssistedProblems;

public class BookMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("Automic Habit","James Clear");
		Book b2 = new Book("The power of subconsius mind","Johsep merhpy");
		Book b3 = new Book("Think rich and grow rich","XYZ");
		
		// Creating libraries
        Library cityLibrary = new Library("City Library");
        Library schoolLibrary = new Library("School Library");
        
        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);
        
        schoolLibrary.addBook(b3);
        schoolLibrary.addBook(b1);
        
        cityLibrary.displayLibraryBook();
        schoolLibrary.displayLibraryBook();
	}

}
