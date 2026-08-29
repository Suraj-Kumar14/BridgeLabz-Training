package com.fundoo.notes.batch;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.fundoo.notes.dto.batch.ExportNoteDTO;
import com.fundoo.notes.entity.Note;

@Component
public class ExportNoteProcessor
        implements ItemProcessor<Note, ExportNoteDTO> {

    @Override
    public ExportNoteDTO process(Note note) {

        ExportNoteDTO dto = new ExportNoteDTO();

        dto.setNoteId(note.getNoteId());
        dto.setUserId(note.getUserId());
        dto.setTitle(note.getTitle());
        dto.setDescription(note.getDescription());

        dto.setPinned(note.isPinned());
        dto.setArchived(note.isArchived());
        dto.setTrashed(note.isTrashed());

        dto.setCreatedAt(note.getCreatedAt());
        dto.setUpdatedAt(note.getUpdatedAt());

        // Convert tags to comma-separated String
        if (note.getTags() != null && !note.getTags().isEmpty()) {

            String tags = note.getTags()
                    .stream()
                    .map(tag -> tag.getName())
                    .sorted()
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("");

            dto.setTags(tags);

        } else {

            dto.setTags("");
        }

        return dto;
    }
}