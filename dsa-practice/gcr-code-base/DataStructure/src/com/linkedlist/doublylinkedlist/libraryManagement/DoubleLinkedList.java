package com.linkedlist.doublylinkedlist.libraryManagement;

public class DoubleLinkedList {
	Book head;
	Book prev;
	Book tail;
	
	//add book at the beginning
	public void addAtBeginning(String bookTitle, String author, int genreation, int bookID, boolean availability) {
		Book newBook = new Book(bookTitle, author, genreation, bookID, availability);
		if(head==null) {
			head = tail =newBook;
			System.out.println("Added book at beginning-> "+bookTitle);
			return;
		}
		newBook.next = head;
		head.prev = newBook;
		head = newBook;
		System.out.println("Added book at beginnig-> "+bookTitle);
	}
	
	//add book at the end
	public void addAtEnd(String bookTitle, String author, int genreation, int bookID, boolean availability) {
		Book newBook = new Book(bookTitle, author, genreation, bookID, availability);
		
		if(head==null) {
			head = tail = newBook;
			System.out.println("Added book at end-> "+bookTitle);
			return;
		}
		tail.next = newBook;
		newBook.prev = tail;
		tail = newBook;
		
		System.out.println("Added book at end-> "+bookTitle);
	}
	
	//display all book forward
	public void displayForward() {
		System.out.println("\n-------------------------Show all book Forward-----------------------------------------");
		Book temp = head;
		while(temp!=null) {
			displayBook(temp);
			temp = temp.next;
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	//display all book reversed 
	public void displayReverse() {
		System.out.println("\n-------------------------Show all book Reversed-------------------------------");
		Book temp = tail;
		while(temp!=null) {
			displayBook(temp);
			temp = temp.prev;
		}
		System.out.println("-------------------------------------------------------------------------------");
	}
	//search by bookID
	public void searchByID(int id) {
		Book temp = head;
		while(temp.next!=null) {
			if(temp.bookID==id) {
				System.out.println("\n------------Book Found---------------");
				displayBook(temp);
				System.out.println("---------------------------------------");
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nBook not found with id: "+id);
	}
	
	//search book by author
	public void searchByAuthor(String au) {
		Book temp = head;
		System.out.println("---------------Find Book By Author------------------");
		while(temp!=null) {
			if(temp.author.equals(au)) {
				displayBook(temp);
				System.out.println("-----------------------------------------------------");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Book not found with author: "+au);
		System.out.println("--------------------------------------------------------");
	}
	
	//count number of book in library
	public void countBook() {
		int count = 0;
		System.out.println("\n-----------Total Count Book-------------");
		Book temp = head;
		while(temp!=null) {
			count+=1;
			temp = temp.next;
		}
		System.out.println("Total Book: "+count);
		System.out.println("-----------------------");
	}
	//display each node book
	public void displayBook(Book book) {
		System.out.println(
				"Book Title: "+book.bookTitle+
				" | Author: "+book.author+
				" | Generation: "+book.genreation+
				" | Book Id: "+book.bookID+
				" | Availability: "+book.availability
		);
	}
}