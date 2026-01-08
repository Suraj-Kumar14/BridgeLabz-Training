package com.linkedlist.singlylinkedlist.socialmedia;

public class UserNode {
	public int userID;
	public String name;
	public int age;
	
	FriendsNode friends;
	UserNode next;
	public UserNode(int userID, String name, int age) {
		super();
		this.userID = userID;
		this.name = name;
		this.age = age;
		this.friends = null;
		this.next = null;
	}
}