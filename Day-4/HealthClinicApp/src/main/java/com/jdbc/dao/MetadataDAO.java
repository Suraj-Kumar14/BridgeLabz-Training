package com.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.connection.DBConnection;

public class MetadataDAO {

	public void showPatientMetadata() {

		String sql = "SELECT * FROM patient";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			ResultSetMetaData meta = rs.getMetaData();

			int columnCount = meta.getColumnCount();

			for (int i = 1; i <= columnCount; i++) {

				System.out.print(meta.getColumnName(i) + "\t");

			}

			System.out.println();

			while (rs.next()) {

				for (int i = 1; i <= columnCount; i++) {

					System.out.print(rs.getString(i) + "\t");

				}

				System.out.println();

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}