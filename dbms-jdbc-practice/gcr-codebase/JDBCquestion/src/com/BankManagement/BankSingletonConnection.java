package com.BankManagement; 
import java.sql.*;

public class BankSingletonConnection {

    private static BankSingletonConnection instance; 	
    private Connection connection;

    private static final String URL="jdbc:mysql://localhost:3306/banking_db"; 
    private static final String USERNAME="root";
    private static final String PASSWORD="Suraj@123";

    private BankSingletonConnection() {
        try {
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }		
    }

    public static BankSingletonConnection getInstance() {
        if(instance == null) {
            instance = new BankSingletonConnection();   
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
