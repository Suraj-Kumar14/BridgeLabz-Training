package com.springmvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;
import com.springmvc.rowmapper.UserRowMapper;

@Repository
public class UserDAO {

	private final JdbcTemplate jdbcTemplate;

	public UserDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean emailExists(String email) {

		String sql = "SELECT COUNT(*) FROM users WHERE email = ?";

		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);

		return count != null && count > 0;
	}

	public int registerUser(User user) {

		String sql = "INSERT INTO users " + "(name, email, password, mobile, city) " + "VALUES (?, ?, ?, ?, ?)";

		return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getMobile(),
				user.getCity());
	}

	public User loginUser(String email, String password) {

		String sql = "SELECT * FROM users " + "WHERE email = ? AND password = ?";

		try {

			return jdbcTemplate.queryForObject(sql, new UserRowMapper(), email, password);

		} catch (Exception e) {

			return null;
		}
	}
}