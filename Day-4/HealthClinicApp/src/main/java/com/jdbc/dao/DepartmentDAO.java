package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class DepartmentDAO {

	Scanner sc = new Scanner(System.in);

	public void addDepartment() {

		String sql = "INSERT INTO department(department_name) VALUES(?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			System.out.print("Enter Department Name: ");
			String name = sc.nextLine();

			ps.setString(1, name);

			int rows = ps.executeUpdate();

			if (rows > 0) {

				try (ResultSet rs = ps.getGeneratedKeys()) {

					if (rs.next()) {
						System.out.println("\nDepartment Added Successfully.");
						System.out.println("Generated Department ID : " + rs.getInt(1));
					}

				}

			} else {
				System.out.println("Failed to add Department.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewDepartments() {

		String sql = "SELECT * FROM department";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				System.out.println("-----------------------");
				System.out.println("Department ID : " + rs.getInt("department_id"));
				System.out.println("Department    : " + rs.getString("department_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDepartment() {

		String sql = "UPDATE department SET department_name=? WHERE department_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.print("Enter Department ID : ");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter New Name : ");
			String name = sc.nextLine();

			ps.setString(1, name);
			ps.setInt(2, id);

			if (ps.executeUpdate() > 0)
				System.out.println("Updated.");
			else
				System.out.println("Department Not Found.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteDepartment() {

		String sql = "DELETE FROM department WHERE department_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.print("Enter Department ID : ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			if (ps.executeUpdate() > 0)
				System.out.println("Deleted.");
			else
				System.out.println("Department Not Found.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchDepartment() {

		String sql = "SELECT * FROM department WHERE department_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			System.out.print("Enter Department ID : ");
			int id = sc.nextInt();

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					System.out.println("Department ID	: " + rs.getInt("department_id"));
					System.out.println("Department 		: " + rs.getString("department_name"));

				} else {
					System.out.println("Department Not Found.");
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
