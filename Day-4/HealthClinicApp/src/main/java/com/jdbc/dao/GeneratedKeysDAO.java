package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.connection.DBConnection;

public class GeneratedKeysDAO {

	Scanner sc = new Scanner(System.in);

	public void addDepartment() {

		String sql = "INSERT INTO department(department_name) VALUES(?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			System.out.print("Enter Department Name: ");
			String departmentName = sc.nextLine();

			ps.setString(1, departmentName);

			int rows = ps.executeUpdate();

			if (rows > 0) {

				try (ResultSet rs = ps.getGeneratedKeys()) {

					if (rs.next()) {
						System.out.println("\nDepartment Added Successfully.");
						System.out.println("Generated Department ID : " + rs.getInt(1));
					}

				}

			} else {
				System.out.println("Department could not be added.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}