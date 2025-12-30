package com.objectmodeling.AssistedProblems;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String bankName;
	private List<Account>accounts=new ArrayList<>();
	
	public Bank(String bankName) {
		this.bankName=bankName;
	}
	
	public Account openAccount(Customer customer) {
		Account account=new Account(this);
		accounts.add(account);
		customer.addAccount(account);
		return account;
	}
}
