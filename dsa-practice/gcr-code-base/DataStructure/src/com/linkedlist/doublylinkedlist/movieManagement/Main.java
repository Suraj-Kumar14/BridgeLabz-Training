package com.linkedlist.doublylinkedlist.movieManagement;

public class Main {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.addAtBeginning("RRR", "SS Raja", 2023, 8.9);
		l1.addAtBeginning("gggg", "SS Raja", 2020, 4.9);
		l1.addAtEnd("dddd", "SS Raja", 2022, 7.9);
		l1.addAtPosition("bbbb", "Yash", 2019, 5.7,3);
		
		l1.displayForward();
		l1.displayReverse();
		System.out.println();
		
		l1.searchMovie("SS Raja",8.9);
		System.out.println();
		
		l1.removeRecord("dddd");
		
		l1.updateMovies("RRR",8.3);
		
		l1.displayForward();
		l1.displayReverse();
		
	}
}
