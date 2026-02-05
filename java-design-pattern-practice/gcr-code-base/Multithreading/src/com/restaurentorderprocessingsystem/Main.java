package com.restaurentorderprocessingsystem;

public class Main {

	public static void main(String[] args) {
		Thread chef1 = new Thread(new Chef("Chef 1","Pizza",3000L));
		Thread chef2 = new Thread(new Chef("Chef 2","Hot Dog",2000L));
		Thread chef3 = new Thread(new Chef("Chef 3","Burgger",7000L));
		Thread chef4 = new Thread(new Chef("Chef 4","Pasta",5000L));
		
		chef1.start();
		chef2.start();
		chef3.start();
		chef4.start();
		
		try {
			chef1.join();
			chef2.join();
			chef3.join();
			chef4.join();
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		
		System.out.println("...\nKitchen closed - All orders completed");
	}
}