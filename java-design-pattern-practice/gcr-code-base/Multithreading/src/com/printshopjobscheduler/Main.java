package com.printshopjobscheduler;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		 System.out.println("Starting print jobs...");
	        long startTime = System.currentTimeMillis();

	        Thread job1 = new Thread(new PrintJob("Job1", 10, 5));
	        Thread job2 = new Thread(new PrintJob("Job2", 5, 8));
	        Thread job3 = new Thread(new PrintJob("Job3", 15, 3));
	        Thread job4 = new Thread(new PrintJob("Job4", 8, 6));
	        Thread job5 = new Thread(new PrintJob("Job5", 12, 7));

	        // Set thread priorities
	        job1.setPriority(5);
	        job2.setPriority(8);
	        job3.setPriority(3);
	        job4.setPriority(6);
	        job5.setPriority(7);

	        // Start all jobs
	        job1.start();
	        job2.start();
	        job3.start();
	        job4.start();
	        job5.start();

	        // Wait for completion
	        job1.join();
	        job2.join();
	        job3.join();
	        job4.join();
	        job5.join();

	        long endTime = System.currentTimeMillis();
	        System.out.println("All jobs completed in " + (endTime - startTime) + "ms");
	    }	
	
}
