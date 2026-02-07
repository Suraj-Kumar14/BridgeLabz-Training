package com.printshopjobscheduler;

public class PrintJob implements Runnable{
	private String jobName;
	private int numberOfPages;
	private int priority;
    private static final Object PRINTER = new Object();
	
	public PrintJob(String jobName, int numberOfPages, int priority) {
		this.jobName = jobName;
		this.numberOfPages = numberOfPages;
		this.priority = priority;
	}


	@Override
	public void run() {
			synchronized(PRINTER) {
				String priorityLabel=getPriorityLabel(priority);
				
				for(int i=0;i<=numberOfPages;i++) {
					System.out.println(
	                        "[" + priorityLabel + "] Printing " +
	                        jobName + " - Page " + i + " of " + numberOfPages
	                );
					 try {
		                    Thread.sleep(100); 
		                } catch (InterruptedException e) {
		                    e.printStackTrace();
		                }
				}
			}
	}


	private String getPriorityLabel(int priority2) {
		if(priority>=8) return "High Priority";
		if(priority>=5) return "Medium Priority";
		return "Low Priority";
		
	}

}
