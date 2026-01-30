package com.interfacepractice.functionalinterface;

public class JobExecution {

	public static void main(String[] args) {
		//Runnable using lambda
		Runnable job=()->{
			System.out.println("Background job started..");
			System.out.println("Running in thread: "+Thread.currentThread().getName());
		};
		
		//create a new thread with the job
		Thread thread=new Thread(job);
		//start the background execution
		thread.start();
		
		System.out.println("main thread continue execution");

	}

}
