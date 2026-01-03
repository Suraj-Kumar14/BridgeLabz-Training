package com.EwalletApplication;

public class EwalletApp {
	  public static void main(String[] args) {
	        User alice = new User("Alice", new PersonalWallet(1000));
	        User bob = new User("Bob", new BusinessWallet(5000));

	        alice.getWallet().transferTo(bob, 500);  // PersonalWallet logic
	        bob.getWallet().transferTo(alice, 1000); // BusinessWallet logic
	    }

}
