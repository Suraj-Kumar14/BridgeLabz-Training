package com.jdbc.dao;

import java.sql.*;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class AppointmentDAO {

	Scanner sc = new Scanner(System.in);

	public void bookAppointment() {

		String sql = "INSERT INTO appointment(patient_id,doctor_id,appointment_date,status) VALUES(?,?,?,?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Patient ID: ");
			int patientId = sc.nextInt();

			System.out.print("Enter Doctor ID: ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Appointment Date (yyyy-MM-dd HH:mm:ss): ");
			String date = sc.nextLine();

			System.out.print("Enter Status: ");
			String status = sc.nextLine();

			ps.setInt(1, patientId);
			ps.setInt(2, doctorId);

			try {
				ps.setTimestamp(3, Timestamp.valueOf(date));

			} catch (IllegalArgumentException e) {
				System.out.println("Invalid Date Format.");
				return;
			}

			ps.setString(4, status);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Appointment Booked Successfully.");
			else
				System.out.println("Failed to booked Appointment.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewAppointments() {

		String sql = "SELECT * FROM appointment";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				System.out.println("------------------------------");
				System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
				System.out.println("Patient ID     : " + rs.getInt("patient_id"));
				System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
				System.out.println("Date           : " + rs.getTimestamp("appointment_date"));
				System.out.println("Status         : " + rs.getString("status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAppointment() {

		String sql = "UPDATE appointment SET patient_id=?,doctor_id=?,appointment_date=?,status=? WHERE appointment_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Appointment ID: ");
			int appointmentId = sc.nextInt();

			System.out.print("Enter Patient ID: ");
			int patientId = sc.nextInt();

			System.out.print("Enter Doctor ID: ");
			int doctorId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter Date (yyyy-MM-dd HH:mm:ss): ");
			String date = sc.nextLine();

			System.out.print("Enter Status: ");
			String status = sc.nextLine();

			ps.setInt(1, patientId);
			ps.setInt(2, doctorId);
			ps.setTimestamp(3, Timestamp.valueOf(date));
			ps.setString(4, status);
			ps.setInt(5, appointmentId);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Appointment Updated.");
			else
				System.out.println("Appointment Not Found.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cancelAppointment() {

		String sql = "UPDATE appointment SET status='Cancelled' WHERE appointment_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Appointment ID: ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Appointment Deleted.");
			else
				System.out.println("Appointment Not Found.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchAppointment() {

		String sql = "SELECT * FROM appointment WHERE appointment_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			System.out.print("Enter Appointment ID: ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("Appointment ID : " + rs.getInt("appointment_id"));
					System.out.println("Patient ID     : " + rs.getInt("patient_id"));
					System.out.println("Doctor ID      : " + rs.getInt("doctor_id"));
					System.out.println("Date           : " + rs.getTimestamp("appointment_date"));
					System.out.println("Status         : " + rs.getString("status"));

				} else {
					System.out.println("Appointment Not Found.");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}