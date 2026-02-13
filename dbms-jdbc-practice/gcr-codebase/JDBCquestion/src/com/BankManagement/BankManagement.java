package com.BankManagement;

import java.sql.*;

public class BankManagement implements BankDAO{

	BankSingletonConnection connection=BankSingletonConnection.getInstance();
	@Override
	public void createAccount(AccountDTO account) throws SQLException {
		String sql="INSERT INTO accounts (account_holder,account_number,balance) VALUES (?,?,?)";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1,account.getAccountHolderName());
		ps.setString(2, account.getAccountNumber());
		ps.setDouble(3,account.getBalance());
		
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Account created with account number "+account.getAccountNumber());
		}
		
	}

	@Override
	public void transferMoney(String sender, String receiver, double amount) throws SQLException {

	    Connection con = connection.getConnection();
	    con.setAutoCommit(false);

	    String status = "FAILED";

	    try {

	        // Check sender
	        String senderSQL = "SELECT balance FROM accounts WHERE account_number=?";
	        PreparedStatement ps = con.prepareStatement(senderSQL);
	        ps.setString(1, sender);
	        ResultSet rs = ps.executeQuery();

	        if (!rs.next()) {
	            throw new SQLException("Sender account not found");
	        }

	        double senderBalance = rs.getDouble("balance");
	        if (senderBalance < amount) {
	            throw new SQLException("Insufficient Balance!");
	        }

	        // Check receiver
	        String receiverSQL = "SELECT account_number FROM accounts WHERE account_number=?";
	        PreparedStatement ps1 = con.prepareStatement(receiverSQL);
	        ps1.setString(1, receiver);
	        ResultSet rs1 = ps1.executeQuery();

	        if (!rs1.next()) {
	            throw new SQLException("Receiver account not found");
	        }

	        // Deduct sender
	        PreparedStatement ps2 = con.prepareStatement(
	                "UPDATE accounts SET balance=balance-? WHERE account_number=?");
	        ps2.setDouble(1, amount);
	        ps2.setString(2, sender);
	        ps2.executeUpdate();

	        // Add receiver
	        PreparedStatement ps3 = con.prepareStatement(
	                "UPDATE accounts SET balance=balance+? WHERE account_number=?");
	        ps3.setDouble(1, amount);
	        ps3.setString(2, receiver);
	        ps3.executeUpdate();

	        status = "SUCCESS";

	        // Insert transaction BEFORE commit
	        PreparedStatement ps4 = con.prepareStatement(
	                "INSERT INTO transaction_history (from_account,to_account,transfer_amount,status) VALUES (?,?,?,?)");

	        ps4.setString(1, sender);
	        ps4.setString(2, receiver);
	        ps4.setDouble(3, amount);
	        ps4.setString(4, status);
	        ps4.executeUpdate();

	        con.commit();
	        System.out.println("Money transferred successfully!");

	    } catch (SQLException e) {

	        con.rollback();

	        // Insert failed transaction
	        PreparedStatement ps4 = con.prepareStatement(
	                "INSERT INTO transaction_history (from_account,to_account,transfer_amount,status) VALUES (?,?,?,?)");

	        ps4.setString(1, sender);
	        ps4.setString(2, receiver);
	        ps4.setDouble(3, amount);
	        ps4.setString(4, "FAILED");
	        ps4.executeUpdate();

	        con.commit();

	        System.out.println("Transfer failed: " + e.getMessage());
	    }

	    con.setAutoCommit(true);
	}


	@Override
	public void checkBalance(String accountNumber) throws SQLException {
		String sql="SELECT * FROM accounts WHERE account_number=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1, accountNumber);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			AccountDTO dto=new AccountDTO(
							rs.getString("account_holder"),
							rs.getString("account_number"),
							rs.getDouble("balance")
							);
			
			System.out.println("current balance for "+accountNumber+": "+dto.getBalance());
		}else {
			System.out.println("Error: Account number not found!");
		}
		
	}

	@Override
	public void checkTransaction(String accountNumber) throws SQLException {
		String sql="SELECT * FROM transaction_history WHERE from_account=? OR to_account=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setString(1, accountNumber);
		ps.setString(2,accountNumber);
		
		ResultSet rs=ps.executeQuery();
		
		boolean found=false;
		
		 while (rs.next()) {
		        found = true;

		        System.out.println(
		                "From: " + rs.getString("from_account") +
		                " | To: " + rs.getString("to_account") +
		                " | Amount: " + rs.getDouble("transfer_amount") +
		                " | Status: " + rs.getString("status") +
		                " | Date: " + rs.getTimestamp("txn_date")
		        );
		    }

		    if (!found) {
		        System.out.println("No transactions found.");
		    }
	}

}
