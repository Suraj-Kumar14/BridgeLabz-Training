package com.linkedlist.doublylinkedlist.movieManagement;

public class LinkedList {
	private MovieRecord head;
	private MovieRecord prev;
	private MovieRecord tail;
	
	//Add at the beginning
	public void addAtBeginning(String title,String director,int YOR,double rating) {
		MovieRecord newNode=new MovieRecord(title,director,YOR,rating);
		if(head==null) {
			head = tail = newNode;
			System.out.println("Added at beginning.");
			return;
		}
		
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		System.out.println("Added at the beginning using doubly LinkedList!");
	}
	
	//Add at the end
	public void addAtEnd(String title,String director,int YOR,double rating) {
		MovieRecord newNode=new MovieRecord(title,director,YOR,rating);
		if(head==null) {
			head = tail = newNode;
			return;
		}
		
		MovieRecord temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=newNode;
		newNode.prev = temp;
		temp=tail=newNode;
		System.out.println("Added at the end!");		
	}
	
	//Add at Specific position
	public void addAtPosition(String title,String director,int YOR,double rating, int position) {
		MovieRecord newNode=new MovieRecord(title,director,YOR,rating);
		if(position<=1) {
			addAtBeginning(title,director,YOR,rating);
			System.out.println("Added at position!");
			return;
		}
		MovieRecord temp=head;
		for(int i=1;i<position-1 && temp!=null;i++ ) {
			temp=temp.next;
		}
		if(temp==null) {
			System.out.println("Invalid position!");
			return;
		}
		newNode.next=temp.next;
		if(temp.next!=null) {
			temp.next.prev=newNode;
		}
		temp.next=newNode;
		newNode.prev=temp;
		if(newNode.next==null) {
			tail=newNode;
		}
		System.out.println("Added at Position!");
	}
	
	//Remove movie record by movie Title
	public void removeRecord(String title) {
		if(head==null) {
			System.out.println("Movie Title not found!");
			return;
		}
		
		MovieRecord temp = head;
		while(temp!=null) {
		   if(temp.title.equalsIgnoreCase(title)) {
			   //only one node
			 if(temp.prev == null && temp.next==null) {
				   head = tail=null;
	            }
			 
	            // removing head
	            else if (temp.prev == null) {
	                head=temp.next;
	                head.prev=null;	                
	            }
			 
			 	//Removing tail
	            else if(temp.next==null) {
	            	tail=temp.prev;
	            	tail.next=null;
	            }
			 
	            // removing middle
	            else {
	                temp.prev.next = temp.next;
	                temp.next.prev = temp.prev;	                
	            }
			  System.out.println("Removed movie: " + temp.title);
			  return;
			 }
		   temp = temp.next;
		}
		
		System.out.println("Movie Not Found !");
	}
	
	//Search movie record by director and rating
	public void searchMovie(String director,double rating) {
		MovieRecord temp=head;
		System.out.println("------Movie search------");
		if(head==null) {
			System.out.println("Empty linkedlist!");
			return;
		}
		while(temp!=null) {
			if(temp.director.equalsIgnoreCase(director) && temp.rating==rating) {
				display(temp);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Movie not found!");
	}
	
	//Update movies rating based on the movie Title
	public void updateMovies(String title,double rating) {
		MovieRecord temp=head;
		while(temp!=null) {
			if(temp.title.equalsIgnoreCase(title)) {
				temp.rating=rating;
				System.out.println("------Movies Updated------");
				display(temp);
				return;
			}
			temp=temp.next;
		}
		System.out.println("Movies not found!");
	}
	
	//display
	public void displayForward() {
		MovieRecord temp = head;
		System.out.println();
		System.out.println("-----Movie in Forward order----- ");
		while(temp!=null) {
			display(temp);
			temp = temp.next;
		}
	}
	
	//display each
	public void display(MovieRecord temp) {
		System.out.println(
				" |Movie Title: "+temp.title+
				" | Movie Director: "+temp.director+
				" | Year of release: "+temp.YOR+
				" | Rating: "+temp.rating
		);
	}
	public void displayReverse() {
		MovieRecord temp=tail;
		System.out.println();
		System.out.println("-----Movie in Reverse order----- ");
		while(temp!=null) {
			display(temp);
			temp=temp.prev;
		}
		
	}
}
