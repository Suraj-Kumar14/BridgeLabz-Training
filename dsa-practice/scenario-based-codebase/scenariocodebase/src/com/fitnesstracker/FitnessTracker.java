package com.fitnesstracker;

public class FitnessTracker {

	public static void main(String[] args) {
		
		StepCount step=new StepCount();
		step.addUser(new User("aalu",18000));
		step.addUser(new User("kali",20000));
		step.addUser(new User("bholu",15000));
		step.addUser(new User("solu",17000));
		step.addUser(new User("monu",19000));
		
		step.showUser();
		step.sortUser();
		step.showUser();
		
	}

}
