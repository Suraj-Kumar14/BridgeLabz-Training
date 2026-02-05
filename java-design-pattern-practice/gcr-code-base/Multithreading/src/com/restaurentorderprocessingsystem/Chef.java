package com.restaurentorderprocessingsystem;

public class Chef extends Thread{
	private String chefName;
	private String dish;
	private Long time;

	
	public Chef(String chefName, String dish, long time) {
		this.chefName = chefName;
		this.dish = dish;
		this.time = time;
	}

	public String getChefName() {
		return chefName;
	}

	public String getDish() {
		return dish;
	}

	public Long getTime() {
		return time;
	}
	
	
	public void run() {
		prepareFood();
	}
	
	public void prepareFood() {
		long chunk = time/4;
		try {
			System.out.println("[ "+getChefName()+"] Started Preparing "+getDish());
			for(int i=25;i<=100;i+=25) {
				System.out.println("[ "+getChefName()+"] Preparing "+getDish() + i +" % complete");
				Thread.sleep(chunk);
			}
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}
