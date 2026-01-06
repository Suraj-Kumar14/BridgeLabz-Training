package com.linkedlist.doublylinkedlist.libraryManagement;

public class Main {
	public static void main(String[] args) {
		DoubleLinkedList l1 = new DoubleLinkedList();
		
		l1.addAtBeginning("Automic habits", "James clear", 2022, 101, true);
		l1.addAtBeginning("XXXXXXX", "HHHHH", 2021, 102, false);
		l1.addAtBeginning("YYYYYYY", "GGGGG", 2012, 103, true);
		
		l1.addAtEnd("SSSSSSS", "DDDD", 2020, 105, true);

		l1.displayForward();
		l1.displayReverse();
		
		l1.searchByID(102);
		
		l1.countBook();
		
		l1.searchByAuthor("James clear");
	}
}
