package com.fundoo_notes.batch.batchExport;

import com.fundoo_notes.dto.batch.ExportNoteDTO;
import com.fundoo_notes.entity.Note;

import org.springframework.batch.infrastructure.item.ItemProcessor;



public class DatabaseNoteProcessor
        implements ItemProcessor<Note, ExportNoteDTO> {

    @Override
    public ExportNoteDTO process(Note note) {

        return new ExportNoteDTO(
                note.getNoteId(),
                note.getTitle(),
                note.getDescription()
        );
    }
}