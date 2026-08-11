package com.greetings.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.greetings.entity.Greetings;
import com.greetings.service.GreetingService;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

	private final GreetingService greetingService;

	public GreetingController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@GetMapping
	public String getAllGreetings(Model model, HttpSession session) {

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/login";
		}

		model.addAttribute("greetings", greetingService.getAllGreetings());

		return "greetings";
	}

	@GetMapping("/new")
	public String showCreateForm(Model model, HttpSession session) {

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/login";
		}

		model.addAttribute("greeting", new Greetings());

		return "greeting-form";
	}

	@PostMapping
	public String createGreeting(@ModelAttribute("greeting") Greetings greeting, HttpSession session) {

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/login";
		}

		greetingService.saveGreeting(greeting);

		return "redirect:/greetings";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model, HttpSession session) {

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/login";
		}

		Greetings greeting = greetingService.getGreetingById(id);

		model.addAttribute("greeting", greeting);

		return "greeting-form";
	}

	@GetMapping("/delete/{id}")
	public String deleteGreeting(@PathVariable Long id, HttpSession session) {

		// Check login
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:/login";
		}

		greetingService.deleteGreeting(id);

		return "redirect:/greetings";
	}
}