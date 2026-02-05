package com.scenarioquestion.basicsystemtasks;

//1.Use lambda to run a task in a separate thread.

public class Task {

	public static void main(String[] args) {
		
		Runnable r=()->System.out.println("Thread is running..");
		
		Thread t=new Thread(r);
		
		t.start();

	}

}
