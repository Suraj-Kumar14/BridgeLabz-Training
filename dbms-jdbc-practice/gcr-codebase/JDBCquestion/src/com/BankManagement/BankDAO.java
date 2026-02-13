package com.BankManagement;

import java.sql.SQLException;

public interface BankDAO {

	//create account
	void createAccount(AccountDTO account) throws SQLException;
	
	//transfer money between two account
	void transferMoney(String sender,String receiver,double amount)throws SQLException;
	
	//check balance
	void checkBalance(String accountNumber)throws SQLException;
	
	//check transaction history
	void checkTransaction(String accountNumber)throws SQLException;
	
}
