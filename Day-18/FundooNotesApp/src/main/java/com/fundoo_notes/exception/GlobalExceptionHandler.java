package com.fundoo_notes.exception;

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
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {

		String message = exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

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

	// Note not found
	@ExceptionHandler(NoteNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoteNotFound(NoteNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// Note is not in trash
	@ExceptionHandler(NoteNotTrashedException.class)
	public ResponseEntity<ErrorResponse> handleNoteNotTrashed(NoteNotTrashedException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Tag not found
	@ExceptionHandler(TagNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTagNotFound(TagNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// Reminder not found
	@ExceptionHandler(ReminderNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleReminderNotFound(ReminderNotFoundException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	// Invalid reset token
	@ExceptionHandler(InvalidResetTokenException.class)
	public ResponseEntity<ErrorResponse> handleInvalidResetToken(InvalidResetTokenException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Expired reset token
	@ExceptionHandler(ResetTokenExpiredException.class)
	public ResponseEntity<ErrorResponse> handleResetTokenExpired(ResetTokenExpiredException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	// Unexpected exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<ErrorResponse> handleInvalidOtpException(InvalidOtpException ex) {

		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Something went wrong");

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}