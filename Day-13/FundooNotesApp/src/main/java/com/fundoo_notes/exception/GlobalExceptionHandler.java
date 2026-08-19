package com.fundoo_notes.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Validation exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {

		Map<String, String> errors = new HashMap<>();

		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	// Invalid login credentials
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<Map<String, String>> handleBadCredentials(BadCredentialsException exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", "Invalid email or password");

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}

	// User already exists
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> handleUserAlreadyExists(UserAlreadyExistsException exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	// User not found
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// Invalid reset token
	@ExceptionHandler(InvalidResetTokenException.class)
	public ResponseEntity<Map<String, String>> handleInvalidResetToken(InvalidResetTokenException exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Expired reset token
	@ExceptionHandler(ResetTokenExpiredException.class)
	public ResponseEntity<Map<String, String>> handleResetTokenExpired(ResetTokenExpiredException exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", exception.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Unexpected exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception exception) {

		Map<String, String> response = new HashMap<>();

		response.put("message", "Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}