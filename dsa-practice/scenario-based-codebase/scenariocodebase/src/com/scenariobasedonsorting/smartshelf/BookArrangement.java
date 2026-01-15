package com.scenariobasedonsorting.smartshelf;

import java.util.ArrayList;

public class BookArrangement {
	
	 ArrayList<String>books=new ArrayList<>();
	
	public void addBook(String title) {
		books.add(title);
		
	}
	
	public void insertionSort() {
		for(int i=1;i<books.size();i++) {
			String key=books.get(i);
			int j=i-1;
			while(j>=0 && books.get(j).compareToIgnoreCase(key)>0) {
				books.set(j+1,books.get(j));
				j--;
			}
			books.set(j+1, key);
		}
	}


	public void displayShelf() {
		System.out.println("Current SmartShelf");
		for(String b:books) {
			System.out.println(" - "+b);
		}
	}
}
