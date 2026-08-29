package com.fundoo.notes.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExcelExportService {

    private final NoteRepository noteRepository;

    public byte[] exportNotes(Long userId) throws IOException {

        List<Note> notes = noteRepository.findByUserId(userId);

        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Notes");

            createHeader(sheet);

            int rowNumber = 1;

            for (Note note : notes) {

                Row row = sheet.createRow(rowNumber++);

                row.createCell(0).setCellValue(note.getNoteId());
                row.createCell(1).setCellValue(note.getTitle());
                row.createCell(2).setCellValue(note.getDescription());

                row.createCell(3).setCellValue(note.isPinned());
                row.createCell(4).setCellValue(note.isArchived());
                row.createCell(5).setCellValue(note.isTrashed());

                String tags = "";

                if (note.getTags() != null && !note.getTags().isEmpty()) {

                    tags = note.getTags()
                            .stream()
                            .map(tag -> tag.getName())
                            .sorted()
                            .reduce((a, b) -> a + ", " + b)
                            .orElse("");
                }

                row.createCell(6).setCellValue(tags);

                if (note.getCreatedAt() != null) {
                    row.createCell(7)
                            .setCellValue(note.getCreatedAt().toString());
                }

                if (note.getUpdatedAt() != null) {
                    row.createCell(8)
                            .setCellValue(note.getUpdatedAt().toString());
                }
            }

            for (int i = 0; i < 9; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);

            return outputStream.toByteArray();
        }
    }

    private void createHeader(Sheet sheet) {

        Row header = sheet.createRow(0);

        header.createCell(0).setCellValue("Note ID");
        header.createCell(1).setCellValue("Title");
        header.createCell(2).setCellValue("Description");
        header.createCell(3).setCellValue("Pinned");
        header.createCell(4).setCellValue("Archived");
        header.createCell(5).setCellValue("Trashed");
        header.createCell(6).setCellValue("Tags");
        header.createCell(7).setCellValue("Created At");
        header.createCell(8).setCellValue("Updated At");
    }
}