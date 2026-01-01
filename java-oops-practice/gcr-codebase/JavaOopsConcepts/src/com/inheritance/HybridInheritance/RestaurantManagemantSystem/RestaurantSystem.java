package com.inheritance.HybridInheritance.RestaurantManagemantSystem;

public class RestaurantSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Chef chef=new Chef("Vishal",101);
		Waiter waiter=new Waiter("Alex",201);
		
		chef.displayInfo();
		chef.performDuties();
		System.out.println();
		
		waiter.displayInfo();
		waiter.performDuties();
		
	}

}
