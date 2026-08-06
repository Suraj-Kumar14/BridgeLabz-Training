package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class PatientDAO {

	private final Scanner sc = new Scanner(System.in);

	public void addPatient() {

		String sql = "INSERT INTO patient(name, gender, age, phone, city) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Name: ");
			String name = sc.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Name cannot be empty.");
				return;
			}

			System.out.print("Enter Gender: ");
			String gender = sc.nextLine();

			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			sc.nextLine();

			if (age <= 0) {
				System.out.println("Invalid Age.");
				return;
			}

			System.out.print("Enter Phone Number: ");
			String phone = sc.nextLine();

			if (!phone.matches("\\d{10}")) {
				System.out.println("Phone number must contain exactly 10 digits.");
				return;
			}

			System.out.print("Enter City: ");
			String city = sc.nextLine();

			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setInt(3, age);
			ps.setString(4, phone);
			ps.setString(5, city);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Patient Added Successfully.");
			} else {
				System.out.println("Failed to Add Patient.");
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	public void viewPatients() {

		String sql = "SELECT * FROM patient";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			boolean found = false;

			System.out.println("\n========== PATIENT LIST ==========");

			while (rs.next()) {

				found = true;

				System.out.println("-----------------------------------");
				System.out.println("Patient ID : " + rs.getInt("patient_id"));
				System.out.println("Name       : " + rs.getString("name"));
				System.out.println("Gender     : " + rs.getString("gender"));
				System.out.println("Age        : " + rs.getInt("age"));
				System.out.println("Phone      : " + rs.getString("phone"));
				System.out.println("City       : " + rs.getString("city"));
			}

			if (!found) {
				System.out.println("No Patients Found.");
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	public void updatePatient() {

		String sql = "UPDATE patient SET name=?, gender=?, age=?, phone=?, city=? WHERE patient_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Patient ID to Update: ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter New Name: ");
			String name = sc.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Name cannot be empty.");
				return;
			}

			System.out.print("Enter New Gender: ");
			String gender = sc.nextLine();

			System.out.print("Enter New Age: ");
			int age = sc.nextInt();
			sc.nextLine();

			if (age <= 0) {
				System.out.println("Invalid Age.");
				return;
			}

			System.out.print("Enter New Phone Number: ");
			String phone = sc.nextLine();

			if (!phone.matches("\\d{10}")) {
				System.out.println("Phone number must contain exactly 10 digits.");
				return;
			}

			System.out.print("Enter New City: ");
			String city = sc.nextLine();

			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setInt(3, age);
			ps.setString(4, phone);
			ps.setString(5, city);
			ps.setInt(6, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Patient Updated Successfully.");
			} else {
				System.out.println("Patient ID Not Found.");
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}


	public void deletePatient() {

		String sql = "DELETE FROM patient WHERE patient_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Patient ID to Delete: ");
			int id = sc.nextInt();
			sc.nextLine();

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Patient Deleted Successfully.");
			} else {
				System.out.println("Patient ID Not Found.");
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}


	public void searchPatient() {

		String sql = "SELECT * FROM patient WHERE patient_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Patient ID to Search: ");
			int patientId = sc.nextInt();
			sc.nextLine();

			ps.setInt(1, patientId);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("\n========== PATIENT DETAILS ==========");
					System.out.println("Patient ID : " + rs.getInt("patient_id"));
					System.out.println("Name       : " + rs.getString("name"));
					System.out.println("Gender     : " + rs.getString("gender"));
					System.out.println("Age        : " + rs.getInt("age"));
					System.out.println("Phone      : " + rs.getString("phone"));
					System.out.println("City       : " + rs.getString("city"));
					System.out.println("=====================================");

				} else {
					System.out.println("Patient Not Found.");
				}
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}
}