package com.fundoo_notes.exception;

public class NoteNotFoundException extends RuntimeException {

	public NoteNotFoundException(String msg) {
		super(msg);
	}
}
