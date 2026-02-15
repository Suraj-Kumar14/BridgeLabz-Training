package com.librarymanagementsystem;

import java.sql.*;

public class SingletonDBConnection {
	
	private static SingletonDBConnection instance;	
	private Connection connection;
	
	private static final String URL="jdbc:mysql://localhost:3306/library_db";
	private static final String  USERNAME="root";
	private static final String PASSWORD="Suraj@123";
	
	private SingletonDBConnection() {
		try {
			connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database connection done");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static SingletonDBConnection getInstance() {
		if(instance==null) {
			instance=new SingletonDBConnection();
		}
		return instance;
	}
	
	public  Connection getConnection() {
		return connection;
	}
}
