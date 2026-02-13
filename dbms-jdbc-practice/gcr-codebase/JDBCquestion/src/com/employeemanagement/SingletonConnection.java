package com.employeemanagement;

import java.sql.*;

public class SingletonConnection {

	private static SingletonConnection instance;
	
	private Connection connection;

	private static final String URL="jdbc:mysql://localhost:3306/employee_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="Suraj@123";
	
	private SingletonConnection()  {
		
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database connection done.");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public static SingletonConnection getInstance()  {
		if(instance==null ) {
			return new SingletonConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
		
}
	
	

