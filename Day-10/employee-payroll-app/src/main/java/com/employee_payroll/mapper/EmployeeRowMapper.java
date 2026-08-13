package com.employee_payroll.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee_payroll.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee employee = new Employee();

		employee.setId(rs.getLong("id"));
		employee.setName(rs.getString("name"));
		employee.setEmail(rs.getString("email"));
		employee.setDepartmentId(rs.getLong("department_id"));
		employee.setSalary(rs.getDouble("salary"));
		employee.setJoiningDate(rs.getTimestamp("joining_date").toLocalDateTime());

		return employee;
	}
}