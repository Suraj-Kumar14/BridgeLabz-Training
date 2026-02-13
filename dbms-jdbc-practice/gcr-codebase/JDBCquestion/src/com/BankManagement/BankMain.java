package com.BankManagement;

import java.sql.SQLException;

public class BankMain {

	public static void main(String[] args) {
		BankManagement management = new BankManagement();
		try {
			management.createAccount(new AccountDTO("RAVI","ASDF54321",13330.0));
			management.createAccount(new AccountDTO("KALI","ASDF4532",7830.0));
			management.createAccount(new AccountDTO("SURIYA","ASDF8765",6730.0));
			
			management.transferMoney("ASDF8765", "ASDF4532", 70);
			
			management.checkTransaction("ASDF8765");

			management.checkTransaction("ASDF4532");

			management.checkBalance("ASDF8765");
			management.checkBalance("ASDF4532");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
