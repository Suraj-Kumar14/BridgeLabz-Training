package com.fundoo.auth.exception;

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
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

		String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Invalid login credentials
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleBadCredentials(BadCredentialsException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "Invalid email or password");

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}

	// User already exists
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
	}

	// User not found
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(EmailNotVerifiedException.class)
	public ResponseEntity<ErrorResponse> handleEmailNotVerified(EmailNotVerifiedException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	}

	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<ErrorResponse> handleInvalidOtpException(InvalidOtpException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Something went wrong");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(EmailAlreadyVerifiedException.class)
	public ResponseEntity<ErrorResponse> handleEmailAlreadyVerified(EmailAlreadyVerifiedException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Unexpected exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
