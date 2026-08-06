package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class VisitDAO {

	Scanner sc = new Scanner(System.in);

	public void addVisit() {

		String sql = "INSERT INTO visit(appointment_id, visit_date, diagnosis) VALUES(?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Appointment ID: ");
			int appointmentId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Visit Date (yyyy-MM-dd HH:mm:ss): ");
			String date = sc.nextLine();

			System.out.print("Enter Diagnosis: ");
			String diagnosis = sc.nextLine();

			ps.setInt(1, appointmentId);
			ps.setTimestamp(2, Timestamp.valueOf(date));
			ps.setString(3, diagnosis);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Visit Added Successfully.");
			} else {
				System.out.println("Failed to Add Visit.");
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Date Format! Use: yyyy-MM-dd HH:mm:ss");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewVisits() {

		String sql = "SELECT * FROM visit";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			boolean found = false;

			while (rs.next()) {

				found = true;

				System.out.println("\n----------------------------");
				System.out.println("Visit ID       : " + rs.getInt("visit_id"));
				System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
				System.out.println("Visit Date     : " + rs.getTimestamp("visit_date"));
				System.out.println("Diagnosis      : " + rs.getString("diagnosis"));
			}

			if (!found) {
				System.out.println("No Visit Records Found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateVisit() {

		String sql = "UPDATE visit SET appointment_id=?, visit_date=?, diagnosis=? WHERE visit_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Visit ID: ");
			int visitId = sc.nextInt();

			System.out.print("Enter New Appointment ID: ");
			int appointmentId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter New Visit Date (yyyy-MM-dd HH:mm:ss): ");
			String date = sc.nextLine();

			System.out.print("Enter New Diagnosis: ");
			String diagnosis = sc.nextLine();

			ps.setInt(1, appointmentId);
			ps.setTimestamp(2, Timestamp.valueOf(date));
			ps.setString(3, diagnosis);
			ps.setInt(4, visitId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Visit Updated Successfully.");
			} else {
				System.out.println("Visit ID Not Found.");
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Date Format! Use: yyyy-MM-dd HH:mm:ss");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteVisit() {

		String sql = "DELETE FROM visit WHERE visit_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Visit ID: ");
			int visitId = sc.nextInt();

			ps.setInt(1, visitId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Visit Deleted Successfully.");
			} else {
				System.out.println("Visit ID Not Found.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchVisit() {

		String sql = "SELECT * FROM visit WHERE visit_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Visit ID: ");
			int visitId = sc.nextInt();

			ps.setInt(1, visitId);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("\n----------- Visit Details -----------");
					System.out.println("Visit ID       : " + rs.getInt("visit_id"));
					System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
					System.out.println("Visit Date     : " + rs.getTimestamp("visit_date"));
					System.out.println("Diagnosis      : " + rs.getString("diagnosis"));

				} else {
					System.out.println("Visit Not Found.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}