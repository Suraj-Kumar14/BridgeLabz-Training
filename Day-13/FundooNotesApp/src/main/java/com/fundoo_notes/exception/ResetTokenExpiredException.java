package com.fundoo_notes.exception;

public class ResetTokenExpiredException extends RuntimeException {

    public ResetTokenExpiredException(String message) {
        super(message);
    }
}