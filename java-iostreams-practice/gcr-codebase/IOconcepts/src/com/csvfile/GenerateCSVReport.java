package com.csvfile;

import java.io.*;
import java.sql.*;

public class GenerateCSVReport {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {

        String query = "SELECT emp_id, name, department, salary FROM employees";

        try (
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("employee_report.csv"))
        ) {

            // Write CSV header
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();

            // Write data rows
            while (rs.next()) {
                bw.write(
                    rs.getInt("emp_id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getInt("salary")
                );
                bw.newLine();
            }

            System.out.println("CSV report generated successfully!");

        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

