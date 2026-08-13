package com.employee_payroll.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.employee_payroll.model.Department;

public class DepartmentRowMapper implements RowMapper<Department>{

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Department department = new Department();
		
		department.setDepartmentId(rs.getLong("department_id"));
		department.setDepartmentName(rs.getString("department_name"));
		
		return department;
	}

}
