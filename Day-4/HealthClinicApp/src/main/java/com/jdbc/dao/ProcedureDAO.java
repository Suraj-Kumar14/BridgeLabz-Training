package com.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class ProcedureDAO {

	private final Scanner sc = new Scanner(System.in);

	public void registerPatient() {

		String sql = "{CALL sp_register_patient(?,?,?,?,?)}";

		try (Connection connection = DBConnection.getConnection(); CallableStatement cs = connection.prepareCall(sql)) {

			System.out.print("Enter Name: ");
			String name = sc.nextLine();

			if (name.trim().isEmpty()) {
				System.out.println("Name cannot be empty.");
				return;
			}

			System.out.print("Enter Phone Number: ");
			String phone = sc.nextLine();

			if (!phone.matches("\\d{10}")) {
				System.out.println("Phone number must contain exactly 10 digits.");
				return;
			}

			System.out.print("Enter Age: ");
			int age = sc.nextInt();
			sc.nextLine();

			if (age <= 0) {
				System.out.println("Invalid Age.");
				return;
			}

			System.out.print("Enter Gender: ");
			String gender = sc.nextLine();

			System.out.print("Enter City: ");
			String city = sc.nextLine();

			cs.setString(1, name);
			cs.setString(2, phone);
			cs.setInt(3, age);
			cs.setString(4, gender);
			cs.setString(5, city);

			cs.execute();

			System.out.println("Patient Registered Successfully.");

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	public void totalRevenue() {

		String sql = "{CALL sp_total_revenue(?)}";

		try (Connection connection = DBConnection.getConnection(); CallableStatement cs = connection.prepareCall(sql)) {

			cs.registerOutParameter(1, Types.DECIMAL);

			cs.execute();

			System.out.println("\nTotal Revenue : ₹" + cs.getDouble(1));

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	public void doctorAppointmentCount() {

		String sql = "{CALL sp_doctor_appointment_count(?,?)}";

		try (Connection connection = DBConnection.getConnection(); CallableStatement cs = connection.prepareCall(sql)) {

			System.out.print("Enter Doctor ID: ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			cs.setInt(1, doctorId);
			cs.registerOutParameter(2, Types.INTEGER);

			cs.execute();

			System.out.println("Total Appointments : " + cs.getInt(2));

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		}
	}

	public void getAllPatients() {

		String sql = "{CALL sp_get_all_patients()}";

		try (Connection connection = DBConnection.getConnection();
				CallableStatement cs = connection.prepareCall(sql);
				ResultSet rs = cs.executeQuery()) {

			boolean found = false;

			System.out.println("\n========== PATIENT LIST ==========");

			while (rs.next()) {

				found = true;

				System.out.println("----------------------------------");
				System.out.println("Patient ID : " + rs.getInt("patient_id"));
				System.out.println("Name       : " + rs.getString("name"));
				System.out.println("Age        : " + rs.getInt("age"));
				System.out.println("Gender     : " + rs.getString("gender"));
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
}