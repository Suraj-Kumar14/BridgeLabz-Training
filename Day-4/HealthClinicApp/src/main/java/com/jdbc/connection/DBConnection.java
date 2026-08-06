package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
	private static final String URL ="jdbc:mysql://localhost:3306/healthclinic";
	private static final String USERNAME = "root";
	private static final String PASSWORD="Suraj@123";
	
	public static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			System.out.println("Database Connected Successfully!");
		}catch(ClassNotFoundException e) {
			System.out.println("Jdbc driver not found");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Database connection failed");
			e.printStackTrace();
		}
		return connection;
	}
}
