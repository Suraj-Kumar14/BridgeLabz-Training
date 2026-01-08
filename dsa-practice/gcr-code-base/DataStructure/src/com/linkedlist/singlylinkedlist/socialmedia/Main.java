package com.linkedlist.singlylinkedlist.socialmedia;

public class Main {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.addUser(101, "allu", 21);
		l1.addUser(102, "ravi", 23);
		l1.addUser(103, "kali", 15);
		
		l1.friendConnections(101, 102);
		l1.friendConnections(101, 103);
		
		l1.displayFriends(101);
	}
}