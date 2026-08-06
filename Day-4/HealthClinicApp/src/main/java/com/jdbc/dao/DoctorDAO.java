package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class DoctorDAO {

	private final Scanner sc = new Scanner(System.in);

	public void addDoctor() {

		String sql = "INSERT INTO doctor(name, specialty, department_id) VALUES (?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Doctor Name : ");
			String name = sc.nextLine();

			System.out.print("Enter Specialty : ");
			String specialty = sc.nextLine();

			System.out.print("Enter Department ID : ");
			int departmentId = sc.nextInt();
			sc.nextLine();

			ps.setString(1, name);
			ps.setString(2, specialty);
			ps.setInt(3, departmentId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("\nDoctor Added Successfully.");
			} else {
				System.out.println("\nFailed to Add Doctor.");
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void viewDoctors() {

		String sql = "SELECT * FROM doctor";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			System.out.println("\n========== DOCTOR LIST ==========");

			boolean found = false;

			while (rs.next()) {

				found = true;

				System.out.println("--------------------------------");
				System.out.println("Doctor ID     : " + rs.getInt("doctor_id"));
				System.out.println("Name          : " + rs.getString("name"));
				System.out.println("Specialty     : " + rs.getString("specialty"));
				System.out.println("Department ID : " + rs.getInt("department_id"));
			}

			if (!found) {
				System.out.println("No Doctors Found.");
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void updateDoctor() {

		String sql = "UPDATE doctor SET name=?, specialty=?, department_id=? WHERE doctor_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Doctor ID to Update : ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter New Name : ");
			String name = sc.nextLine();

			System.out.print("Enter New Specialty : ");
			String specialty = sc.nextLine();

			System.out.print("Enter New Department ID : ");
			int departmentId = sc.nextInt();
			sc.nextLine();

			ps.setString(1, name);
			ps.setString(2, specialty);
			ps.setInt(3, departmentId);
			ps.setInt(4, doctorId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Doctor Updated Successfully.");
			} else {
				System.out.println("Doctor Not Found.");
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void deleteDoctor() {

		String sql = "DELETE FROM doctor WHERE doctor_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Doctor ID to Delete : ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			ps.setInt(1, doctorId);

			int rows = ps.executeUpdate();

			if (rows > 0) {
				System.out.println("Doctor Deleted Successfully.");
			} else {
				System.out.println("Doctor Not Found.");
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void searchDoctor() {

		String sql = "SELECT * FROM doctor WHERE doctor_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Doctor ID : ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			ps.setInt(1, doctorId);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("\n========== DOCTOR DETAILS ==========");
					System.out.println("Doctor ID     : " + rs.getInt("doctor_id"));
					System.out.println("Name          : " + rs.getString("name"));
					System.out.println("Specialty     : " + rs.getString("specialty"));
					System.out.println("Department ID : " + rs.getInt("department_id"));
					System.out.println("====================================");

				} else {
					System.out.println("Doctor Not Found.");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}