package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.addBeginning( 101,"Arjun", 22, 'A');
		l1.addEnd(103,"Ram", 23, 'B');
		l1.addAtPosition( 102,"Kishan", 24, 'C', 2);
		
		l1.searchByRoll(102);
		l1.updateGrade(102, 'D');
		l1.viewStudent();
		
		l1.deleteStduent(102);
		l1.viewStudent();
	}

}
