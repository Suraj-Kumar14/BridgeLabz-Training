package com.employee_payroll.dao.employee;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.employee_payroll.mapper.EmployeeRowMapper;
import com.employee_payroll.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private final JdbcTemplate jdbcTemplate;

	public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee save(Employee employee) {

		String sql = "INSERT INTO employees (name, email, department_id, salary)VALUES (?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {

			PreparedStatement ps = connection.prepareStatement(sql, new String[] { "ID" });

			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setLong(3, employee.getDepartmentId());
			ps.setDouble(4, employee.getSalary());

			return ps;

		}, keyHolder);

		Long generatedId = keyHolder.getKey().longValue();

		return findById(generatedId);
	}

	@Override
	public Employee findById(Long id) {

		String sql = "SELECT * FROM employees WHERE id = ? ";

		List<Employee> employees = jdbcTemplate.query(sql, new EmployeeRowMapper(), id);

		if (employees.isEmpty()) {
			return null;
		}

		return employees.get(0);
	}

	@Override
	public List<Employee> findAll() {

		String sql = "SELECT * FROM employees ORDER BY id";

		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	@Override
	public Employee update(Long id, Employee employee) {

		String sql = "UPDATE employees SET name = ?, email = ?, department_id = ?, salary = ? WHERE id = ?";

		int rowsUpdated = jdbcTemplate.update(sql, employee.getName(), employee.getEmail(), employee.getDepartmentId(),
				employee.getSalary(), id);

		if (rowsUpdated == 0) {
			return null;
		}

		return findById(id);
	}

	@Override
	public boolean deleteById(Long id) {

		String sql = "DELETE FROM employees WHERE id = ? ";

		int rowsDeleted = jdbcTemplate.update(sql, id);

		return rowsDeleted > 0;
	}

	@Override
	public boolean existsByEmail(String email) {

		String sql = "SELECT COUNT(*) FROM employees WHERE LOWER(email) = LOWER(?) ";

		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);

		return count != null && count > 0;
	}
}