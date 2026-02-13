package com.BankManagement;

public class AccountDTO {
	private int accountId;
	private String accountHolderName;
	private String accountNumber;
	private double balance;
	
	public AccountDTO(String accountHolderName,String accountNumber, double balance) {
		
		this.accountHolderName = accountHolderName;
		this.accountNumber=accountNumber;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountId + ", accountHolderName=" + accountHolderName + ", accountNumber="
				+ accountNumber + ", balance=" + balance + "]";
	}
	
	
	
}
