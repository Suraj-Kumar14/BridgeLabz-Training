package com.linkedlist.singlylinkedlist.socialmedia;

public class LinkedList {
	/*
	 * Add a friend connection between two users.
	 *Remove a friend connection.
	 *Find mutual friends between two users.
	 * Display all friends of a specific user.
     *Search for a user by Name or User ID.
	 *Count the number of friends for each user.
	 */
	UserNode head;
	
	//add user
	public void addUser(int id, String name, int age) {
		UserNode newUser = new UserNode(id,name,age);
		
		if(head==null) {
			head = newUser;
			System.out.println("New User added success.");
			return;
		}
		
		UserNode temp = head;
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newUser;
		System.out.println("New User added success.");
	}
	
	//search by id
	public UserNode searchByID(int id) {
		if(head==null) {
			return null;
		}
		UserNode temp = head;
		while(temp!=null) {
			if(temp.userID==id) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
	
	//add friend connection
	public void friendConnections(int id1, int id2) {
		UserNode user1 = searchByID(id1);
		UserNode user2 = searchByID(id2);
		
		if(user1==null || user2==null) {
			System.out.println("User not found!");
			return;
		}
		
		addFriends(user1,id2);
		addFriends(user2,id1);
		System.out.println("Added friend success with: "+id1 + " and "+id2);
	}
	
	//helper method add friend 
	private void addFriends(UserNode user, int friendID) {
		FriendsNode newFriends = new FriendsNode(friendID);
		newFriends.next = user.friends;
		user.friends = newFriends;
	}
	
	//remove friend connection
	public void removeFriendConnections(int id1, int id2) {
		UserNode user1 = searchByID(id1);
		UserNode user2 = searchByID(id2);
		
		if(user1==null || user2==null) {
			System.out.println("User not found!");
			return;
		}
		
		removeFriends(user1,id2);
		removeFriends(user2,id1);
		System.out.println("Removed friend success with: "+id1 + " and "+id2);
	}
	
	//helper method to remove friend
	public void removeFriends(UserNode user, int friendID) {
		FriendsNode current = user.friends;
		FriendsNode prev = null;
		
		while(current!=null) {
			if(current.friendID==friendID) {
				if(prev==null) {
					user.friends = current.next;
				}else {
					prev.next = current.next;
				}
				return;
			}
			prev = current;
			current = current.next;
		}
	}
	
	//display all friends
	public void displayFriends(int id) {
		UserNode user = searchByID(id);
		if(user==null) {
			System.out.println("User not found!");
			return;
		}
		
		System.out.println("------------"+user.name+" Friends list--------------------- ");
		
		FriendsNode friend = user.friends;
		
		if(friend==null) {
			System.out.println("No friends found!");
			return;
		}
		
		while(friend!=null) {
			System.out.println("Friend Id: "+friend.friendID);
			friend = friend.next;
		}
		System.out.println("---------------------------------------------------");
	}
}