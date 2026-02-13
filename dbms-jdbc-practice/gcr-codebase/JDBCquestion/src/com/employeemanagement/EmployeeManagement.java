package com.employeemanagement;

import java.sql.*;

public class EmployeeManagement {
	
	SingletonConnection connection=SingletonConnection.getInstance();
	
	//insert employee 
	public void addEmployee(Employee e)throws SQLException{
		
		String sql="INSERT INTO employees(emp_name,department,salary) VALUES (?,?,?)";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1,e.getEmpName());
		ps.setString(2, e.getDepartment());
		ps.setDouble(3, e.getSalary());
		
		int row=ps.executeUpdate();
		if(row>0) {
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) {
				int id=rs.getInt(1);
				e.setEmpId(id);
				System.out.println("Employee added with id: "+id);
			}
		}
	}
	
	//view all employee
	public void showEmployee()throws SQLException {
		String sql="SELECT * FROM employees";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			 int id = rs.getInt("emp_id");
		        String name = rs.getString("emp_name");
		        String dept = rs.getString("department");
		        double salary = rs.getDouble("salary");
		}
	}
	
	//update employee salary by id
	public void updateEmployeeSalary(int id,double salary) throws SQLException {
		
		String sql="UPDATE employees SET salary=? WHERE emp_id=?";		
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		
		ps.setDouble(1, salary);
		ps.setInt(2, id);
		
		int rows=ps.executeUpdate();
		if(rows>0) {
			System.out.println("Employee salary updated successfully.");
		}else {
			System.out.println("Employee not found with id: "+id);
		}
	}
	
	//delete employee by id
	public void deleteEmployee(int id) throws SQLException {
		String sql="DELETE FROM employees WHERE emp_Id=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		int rows=ps.executeUpdate();
		
		if(rows>0) {
			System.out.println("Employee deleted successfully with id "+id);
		}else {
			System.out.println("Employee not found with id "+id);
		}
	}
	
	//Search employee by name
	public void searchEmployee(String name) throws SQLException {
		String sql="SELECT * FROM employees WHERE emp_name=?";
		PreparedStatement ps=connection.getConnection().prepareStatement(sql);
		
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("emp_id")+" "
					+rs.getString("emp_name")+" "
					+rs.getString("department")+" "
					+rs.getDouble("salary"));
		}
	}
}
