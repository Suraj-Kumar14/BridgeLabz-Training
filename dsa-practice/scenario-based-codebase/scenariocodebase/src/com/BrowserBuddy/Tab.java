package com.BrowserBuddy;

public class Tab {
	private Node current;
	
	//open new tab
	public void visitPage(String url) {
		Node newNode=new Node(url);
		if(current!=null) {
			current.next=newNode;
			newNode.prev=current;
		}
		current=newNode;
		System.out.println("Opened: "+url);
	}
	
	//back navigation
	public void Back() {
		if(current!=null && current.prev!=null) {
			current=current.prev;
			System.out.println("Back to: "+current.url);
		}
		else {
			System.out.println("No previous page!");
		}			
	}
	
	//Forward navigation
	public void forwardNavigation() {
		if(current!=null && current.next!=null) {
			current=current.next;
			System.out.println("Forward to: "+current.url);
			return;
		}
		System.out.println("No forward page!");
	}
	
	//get current page url
	public String getCurrentPage() {
		return current!=null ? current.url:"No page available";
	}
	
	public void showHistory() {
		Node temp=current;
		if(current==null) {
			System.out.println("No history!");
			return;
		}
		while(temp.prev!=null) {
			temp=temp.prev;
		}
		System.out.println("History: ");
		while(temp!=null) {
			System.out.println(temp.url+"--->");
			temp=temp.next;
		}
		System.out.println();
	}
}
