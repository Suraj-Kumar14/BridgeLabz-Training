package com.springmvc.service;

import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDAO;
import com.springmvc.model.User;

@Service
public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String registerUser(User user) {

        // Password validation
        if (user.getPassword() == null ||
            user.getPassword().length() < 8) {

            return "Password must be at least 8 characters long.";
        }

        // Email validation
        if (userDAO.emailExists(user.getEmail())) {

            return "Email already registered.";
        }

        // Save user
        int result = userDAO.registerUser(user);

        if (result > 0) {
            return "success";
        }

        return "Registration failed.";
    }

    public User loginUser(String email, String password) {

        return userDAO.loginUser(email, password);
    }
}