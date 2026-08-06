package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.connection.DBConnection;

public class BatchDAO {

	public void batchInsertPatients() {

		String sql = "INSERT INTO patient(name,age,gender,phone,city) VALUES(?,?,?,?,?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			connection.setAutoCommit(false);

			Object[][] patients = {

					{ "Neha Joshi", 23, "Female", "9876511111", "Pune" },
					{ "Aman Verma", 30, "Male", "9876522222", "Delhi" } };

			for (Object[] p : patients) {
				ps.setString(1, (String) p[0]);
				ps.setInt(2, (Integer) p[1]);
				ps.setString(3, (String) p[2]);
				ps.setString(4, (String) p[3]);
				ps.setString(5, (String) p[4]);

				ps.addBatch();
			}

			int[] result = ps.executeBatch();

			connection.commit();

			System.out.println(result.length + " patients inserted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
