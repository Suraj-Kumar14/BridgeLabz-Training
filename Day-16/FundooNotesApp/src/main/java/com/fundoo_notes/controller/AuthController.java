package com.fundoo_notes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundoo_notes.dto.request.user.ForgetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.LoginRequestDTO;
import com.fundoo_notes.dto.request.user.RegisterRequestDTO;
import com.fundoo_notes.dto.request.user.ResetPasswordRequestDTO;
import com.fundoo_notes.dto.request.user.UserPatchRequestDTO;
import com.fundoo_notes.dto.response.LoginResponseDTO;
import com.fundoo_notes.dto.response.UserResponseDTO;
import com.fundoo_notes.service.AuthServiceImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthServiceImpl authService;

	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody RegisterRequestDTO registerRequest) {

		UserResponseDTO response = authService.registerUser(registerRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO request) {

		LoginResponseDTO response = authService.loginUser(request);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgetPasswordRequestDTO request) {

		return ResponseEntity.ok(authService.forgotPassword(request));
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@Valid @RequestBody ResetPasswordRequestDTO request) {

		return ResponseEntity.ok(authService.resetPassword(request));
	}
	
	@PatchMapping("/update")
	public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserPatchRequestDTO rquest){
		
		return ResponseEntity.ok(authService.updateUser(rquest));
	}
}
