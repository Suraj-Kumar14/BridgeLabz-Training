package com.greetings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greetings.entity.User;
import com.greetings.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String showRegisterPage(Model model) {

		model.addAttribute("user", new User());

		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {

		userService.registerUser(user);

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {

		User user = userService.findByUsername(username).orElse(null);

		if (user != null && user.getPassword().equals(password)) {

			session.setAttribute("loggedInUser", user);

			return "redirect:/greetings";
		}

		model.addAttribute("error", "Invalid username and password");

		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/login";
	}
}