package com.employee_payroll.dao.department;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.employee_payroll.mapper.DepartmentRowMapper;
import com.employee_payroll.model.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	private final JdbcTemplate jdbcTemplate;

	public DepartmentDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Department save(Department department) {

		String sql = "INSERT INTO departments(department_name) VALUES(?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, department.getDepartmentName());

			return ps;
		}, keyHolder);

		department.setDepartmentId(keyHolder.getKey().longValue());

		return department;
	}

	@Override
	public Department findById(Long id) {
		
		String sql = "SELECT * FROM departments WHERE department_id=?";
		
		List<Department> departments =jdbcTemplate.query(sql,new DepartmentRowMapper(),id);
		
		if(departments.isEmpty()) {
			return null;
		}
		return departments.get(0);
	}

	@Override
	public List<Department> findAll() {
		String sql = "SELECT * FROM departments ORDER BY department_id";
		
		return jdbcTemplate.query(sql,new DepartmentRowMapper());
	}

	@Override
	public boolean existsByName(String departmentName) {
		String sql = "SELECT COUNT(*) FROM departments WHERE department_name=?";
		
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class,departmentName);
		
		return count != null && count>0;
	}

	@Override
    public boolean deleteById(Long departmentId) {

        String sql = "DELETE FROM departments WHERE department_id = ?";

        int rows =jdbcTemplate.update(sql,departmentId);

        return rows > 0;
    }

}
