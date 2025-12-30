package com.objectmodeling.AssistedProblems;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Account>accounts=new ArrayList<>();
	
	public Customer(String name) {
		this.name=name;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public void viewBalance() {
		System.out.println("Balances for "+name+":");
		for(Account acc: accounts) {
			System.out.println("Account "+acc.getAccountId()+"-> Rs"+acc.getBalance());
		}
	}
	
}
