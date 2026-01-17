package com.smartlibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {
	
	List<Book>books=new ArrayList<>();
	List<Book>borrowBook=new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added!");
		System.out.println();
	}
	
	//borrowed book
	public void borrowBook(int id) {
		 Book found = null;
		    for (Book b : books) {
		        if (b.getId() == id) {
		            found = b;
		            break;
		        }
		    }

		    if (found != null) {
		        books.remove(found);
		        borrowBook.add(found);
		        System.out.println("Book borrowed!");
		    } else {
		        System.out.println("Book not found!");
		    }
		    System.out.println();
	}
	
	//sort book using insertion sort
	public void sortBorrowBook() {
		int n=borrowBook.size();
		for(int i=1;i<n;i++) {
			int j=i-1;
			Book top=borrowBook.get(i);
			while(j>=0 && borrowBook.get(j).getId()>borrowBook.get(j+1).getId()) {
				borrowBook.set(j++, borrowBook.get(j));
				j--;
			}
			j++;
			borrowBook.set(j, top);
		}
		System.out.println("Borrowed book sort successfully.");
	}
	
	public void showBook() {
		if(!books.isEmpty()) {
			System.out.println("----------Total Book----------");
			for(var book: books){
				System.out.println(book);
			 }
		}else {
			System.out.println("No Book borrowed yet!");
		}
		System.out.println();
	}
	
	public void showBorrowBook() {
		if(!borrowBook.isEmpty()) {
			System.out.println("------------Borrowed Book-----------");
			for(var book: borrowBook){
				System.out.println(book);
			 }
		}else {
			System.out.println("No Book borrowed yet!");
		}
		System.out.println();
	}
}
