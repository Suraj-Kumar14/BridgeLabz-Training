package com.linkedlist.doublylinkedlist.movieManagement;

public class MovieRecord {
	String title;
	String director;
	int YOR;
	double rating;
	MovieRecord next;
	MovieRecord prev;
	
	public MovieRecord(String title,String director,int YOR,double rating) {
		this.title=title;
		this.director=director;
		this.YOR=YOR;
		this.rating=rating;
		this.next=null;
		this.prev = null;
	}
}
