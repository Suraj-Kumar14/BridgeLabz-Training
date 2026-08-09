package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String showRegistrationPage() {

		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(User user, Model model) {

		String result = userService.registerUser(user);

		if (result.equals("success")) {

			model.addAttribute("message", "Registration successful! Please login.");

			return "login";

		} else {

			model.addAttribute("error", result);

			return "registration";
		}
	}

	@GetMapping("/login")
	public String showLoginPage() {

		return "login";
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		User user = userService.loginUser(email, password);

		if (user != null) {

			model.addAttribute("user", user);

			return "home";

		} else {

			model.addAttribute("error", "Invalid email or password!");

			return "login";
		}
	}
}