package com.fundoo.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fundoo.auth.dto.request.ForgetPasswordRequestDTO;
import com.fundoo.auth.dto.request.LoginRequestDTO;
import com.fundoo.auth.dto.request.RegisterRequestDTO;
import com.fundoo.auth.dto.request.ResetPasswordRequestDTO;
import com.fundoo.auth.dto.request.UserPatchRequestDTO;
import com.fundoo.auth.dto.request.VerifyOtpRequestDTO;
import com.fundoo.auth.dto.response.LoginResponseDTO;
import com.fundoo.auth.dto.response.UserResponseDTO;
import com.fundoo.auth.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {

		UserResponseDTO response = authService.registerUser(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<String> verifyOtp(@Valid @RequestBody VerifyOtpRequestDTO request) {

		authService.verifyOtp(request);

		return ResponseEntity.ok("Email verified successfully");
	}

	@PostMapping("/resend-otp")
	public ResponseEntity<String> resendOtp(@RequestParam String email) {

		String response = authService.resendVerificationOtp(email);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {

		LoginResponseDTO response = authService.loginUser(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgetPasswordRequestDTO request) {

		String response = authService.forgotPassword(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequestDTO request) {

		String response = authService.resetPassword(request);

		return ResponseEntity.ok(response);
	}

	@PatchMapping("/profile")
	public ResponseEntity<UserResponseDTO> updateProfile(@Valid @RequestBody UserPatchRequestDTO request) {

		UserResponseDTO response = authService.updateUser(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {

		String authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {

			return ResponseEntity.badRequest().body("Authorization token is missing");
		}

		String token = authorizationHeader.substring(7);

		authService.logout(token);

		return ResponseEntity.ok("Logout successfully");
	}
}