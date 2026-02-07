package com.threadstatemonitoringsystem;

public class TaskRunner implements Runnable{

	
	@Override
	public void run() {
		try {
			for(int i=0;i<1_000_000;i++) {
				Math.sqrt(i);
			}
			
			Thread.sleep(2000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
}
