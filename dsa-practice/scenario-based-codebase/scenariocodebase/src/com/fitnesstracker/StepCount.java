package com.fitnesstracker;

import java.util.ArrayList;
import java.util.List;

public class StepCount {
	
	List<User>users=new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
		System.out.println("User added.");
	}
	
	//bubble sort
	public void sortUser() {
		int n=users.size();
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(users.get(j).getStep()<users.get(j+1).getStep()) {
					User temp=users.get(j);
					users.set(j,users.get(j+1) );
					users.set(j+1, temp);
				}
			}
		}
	}
	
	public void showUser() {
		System.out.println("-----Daily step count report-----");
		if(!users.isEmpty()) {
			for(User u:users) {
				System.out.println(u);
			}
		}else {
			System.out.println("No data found!");
		}
		System.out.println();
	}
}
