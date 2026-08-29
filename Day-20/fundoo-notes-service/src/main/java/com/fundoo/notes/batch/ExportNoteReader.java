package com.fundoo.notes.batch;

import java.util.Iterator;
import java.util.List;

import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.stereotype.Component;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;

@Component
public class ExportNoteReader implements ItemReader<Note> {

    private final NoteRepository noteRepository;

    private Iterator<Note> noteIterator;

    public ExportNoteReader(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void initialize(Long userId) {

        List<Note> notes = noteRepository.findByUserId(userId);

        this.noteIterator = notes.iterator();
    }

    @Override
    public Note read() {

        if (noteIterator != null && noteIterator.hasNext()) {
            return noteIterator.next();
        }

        return null;
    }
}