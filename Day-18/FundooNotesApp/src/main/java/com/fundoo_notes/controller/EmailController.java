package com.fundoo_notes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo_notes.service.email.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}

	@PostMapping("/test")
	public ResponseEntity<String> sendTestEmail(@RequestParam String to) {

		emailService.sendEmail(to, "Fundoo Notes SMTP Test", "SMTP email is working successfully!");

		return ResponseEntity.ok("Test email sent successfully");
	}
}