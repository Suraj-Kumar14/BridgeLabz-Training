package com.jdbc.dao;

import java.sql.*;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class BillingDAO {

	Scanner sc = new Scanner(System.in);

	public void addBill() {

		String sql = "INSERT INTO billing(visit_id, amount, payment_status) VALUES(?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Visit ID: ");
			int visitId = sc.nextInt();

			System.out.print("Enter Amount: ");
			double amount = sc.nextDouble();
			sc.nextLine();

			if (amount <= 0) {
				System.out.println("Amount must be greater than 0.");
				return;
			}

			System.out.print("Enter Payment Status: ");
			String status = sc.nextLine();

			ps.setInt(1, visitId);
			ps.setDouble(2, amount);
			ps.setString(3, status);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Bill Added Successfully.");
			else
				System.out.println("Failed to Add Bill.");

		} catch (SQLException e) {

			if (e.getErrorCode() == 1452) {
				System.out.println("Invalid Visit ID.");
			} else {
				System.out.println("Error : " + e.getMessage());
			}
		}
	}

	public void viewBills() {

		String sql = "SELECT * FROM billing";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				System.out.println("\n========== BILL ==========");
				System.out.println("Bill ID        : " + rs.getInt("bill_id"));
				System.out.println("Visit ID       : " + rs.getInt("visit_id"));
				System.out.println("Amount         : " + rs.getDouble("amount"));
				System.out.println("Payment Status : " + rs.getString("payment_status"));
				System.out.println("==========================");

			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void updateBill() {

		String sql = "UPDATE billing SET visit_id=?, amount=?, payment_status=? WHERE bill_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Bill ID: ");
			int billId = sc.nextInt();

			System.out.print("Enter Visit ID: ");
			int visitId = sc.nextInt();

			System.out.print("Enter Amount: ");
			double amount = sc.nextDouble();
			sc.nextLine();

			if (amount <= 0) {
				System.out.println("Amount must be greater than 0.");
				return;
			}

			System.out.print("Enter Payment Status: ");
			String status = sc.nextLine();

			ps.setInt(1, visitId);
			ps.setDouble(2, amount);
			ps.setString(3, status);
			ps.setInt(4, billId);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Bill Updated Successfully.");
			else
				System.out.println("Bill Not Found.");

		} catch (SQLException e) {

			if (e.getErrorCode() == 1452) {
				System.out.println("Invalid Visit ID.");
			} else {
				System.out.println("Error : " + e.getMessage());
			}
		}
	}

	public void deleteBill() {

		String sql = "DELETE FROM billing WHERE bill_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Bill ID: ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Bill Deleted Successfully.");
			else
				System.out.println("Bill Not Found.");

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void searchBill() {

		String sql = "SELECT * FROM billing WHERE bill_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Bill ID: ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("\n========== BILL DETAILS ==========");
					System.out.println("Bill ID        : " + rs.getInt("bill_id"));
					System.out.println("Visit ID       : " + rs.getInt("visit_id"));
					System.out.println("Amount         : " + rs.getDouble("amount"));
					System.out.println("Payment Status : " + rs.getString("payment_status"));
					System.out.println("==================================");

				} else {
					System.out.println("Bill Not Found.");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}