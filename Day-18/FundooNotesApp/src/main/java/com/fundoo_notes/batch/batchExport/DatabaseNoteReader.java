package com.fundoo_notes.batch.batchExport;

import com.fundoo_notes.entity.Note;
import com.fundoo_notes.repository.NoteRepository;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.infrastructure.item.ItemReader;

public class DatabaseNoteReader implements ItemReader<Note> {

	private final Iterator<Note> noteIterator;

	public DatabaseNoteReader(NoteRepository noteRepository, String userEmail) {

		List<Note> notes = noteRepository.findByUserEmail(userEmail);

		this.noteIterator = notes.iterator();
	}

	@Override
	public Note read() {

		if (noteIterator.hasNext()) {
			return noteIterator.next();
		}

		return null;
	}
}