package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class TransactionDAO {

	Scanner sc = new Scanner(System.in);

	public void createVisitAndBill() {

		try (Connection conn = DBConnection.getConnection()) {

			conn.setAutoCommit(false);

			String visitSql = "INSERT INTO visit(appointment_id, visit_date, diagnosis) VALUES (?, NOW(), ?)";

			try (PreparedStatement visitStmt = conn.prepareStatement(visitSql, Statement.RETURN_GENERATED_KEYS)) {

				System.out.print("Enter Appointment ID: ");
				int appointmentId = sc.nextInt();
				sc.nextLine(); // consume newline

				System.out.print("Enter Diagnosis: ");
				String diagnosis = sc.nextLine();

				visitStmt.setInt(1, appointmentId);
				visitStmt.setString(2, diagnosis);

				visitStmt.executeUpdate();

				int visitId;

				try (ResultSet keys = visitStmt.getGeneratedKeys()) {

					keys.next();
					visitId = keys.getInt(1);

				}

				String billSql = "INSERT INTO billing(visit_id, amount, payment_status) VALUES (?, ?, 'Pending')";

				try (PreparedStatement billStmt = conn.prepareStatement(billSql)) {

					System.out.print("Enter Bill Amount: ");
					double amount = sc.nextDouble();

					billStmt.setInt(1, visitId); // generated visit id
					billStmt.setDouble(2, amount);

					billStmt.executeUpdate();

				}

			}

			conn.commit();

			System.out.println("Transaction Successful.");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}