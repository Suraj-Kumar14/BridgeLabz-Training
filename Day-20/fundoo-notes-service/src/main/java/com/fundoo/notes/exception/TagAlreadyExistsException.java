package com.fundoo.notes.exception;

public class TagAlreadyExistsException extends RuntimeException {

    public TagAlreadyExistsException(String message) {
        super(message);
    }
}