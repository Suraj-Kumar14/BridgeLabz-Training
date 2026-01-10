package com.BookShelf;

import java.util.HashMap;
import java.util.LinkedList;

public class Library {
	private HashMap<String,LinkedList<Book>>libraryCatalog;
	
	Library(){
		libraryCatalog=new HashMap<>();
	}
	
	//method addBook to genre
	public void addBook(String genre,Book book) {
		if(!libraryCatalog.containsKey(genre)) {
			libraryCatalog.put(genre,new LinkedList<Book>());
		}
			libraryCatalog.get(genre).add(book);			
			System.out.println(book+" added to  "+genre);	
			System.out.println();
			return;
	}
	
	//Borrow book
	public void borrowBook(String genre,String title) {
		if(libraryCatalog.containsKey(genre)) {
			LinkedList<Book>books=libraryCatalog.get(genre);
			for(Book b: books) {
				if(b.getTitle().equals(title) && !b.isBorrowed) {
					b.isBorrowed=true;
					
					System.out.println(title+" borrowed from "+genre);
				    System.out.println();
					return;
				}
			}
			System.out.println(title+" not found in "+genre);
			System.out.println();
			return ;
		}
		 System.out.println("Book not available to borrow: " + title);
	}
	
	//Return book method
	public void returnBook(String genre,String title) {
		if (libraryCatalog.containsKey(genre)) {
            for (Book b : libraryCatalog.get(genre)) {
                if (b.getTitle().equals(title) && b.isBorrowed) {
                    b.isBorrowed = false; 
                    System.out.println(title + " returned to " + genre);
                    System.out.println();
                    return;
                }
            }
        }
        System.out.println("Book was not borrowed: " + title);
        System.out.println();
	}
	
	//Display catalog
	public void displayCatalog() {
		if(libraryCatalog.isEmpty()) {
			System.out.println("No Genre/Book available!");
			return;
		}
		for(String genre:libraryCatalog.keySet()) {
			System.out.println("Genre: "+genre);
			for(Book book: libraryCatalog.get(genre)) {
				System.out.println(" "+book+ (book.isBorrowed ? "(Borrowed)": "(Available)"));
				System.out.println();
			}
		}
	}
}
