package com.fundoo.notes.batch;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.fundoo.notes.dto.batch.ExportNoteDTO;

@Component
public class ExcelExportWriter implements ItemWriter<ExportNoteDTO> {

    private static final String FILE_PATH = "notes-export.xlsx";

    @Override
    public void write(Chunk<? extends ExportNoteDTO> chunk) throws Exception {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Notes");

            createHeader(sheet);

            int rowNumber = 1;

            for (ExportNoteDTO note : chunk.getItems()) {

                Row row = sheet.createRow(rowNumber++);

                row.createCell(0).setCellValue(note.getNoteId());
                row.createCell(1).setCellValue(note.getTitle());
                row.createCell(2).setCellValue(note.getDescription());
                row.createCell(3).setCellValue(note.isPinned());
                row.createCell(4).setCellValue(note.isArchived());
                row.createCell(5).setCellValue(note.isTrashed());
                row.createCell(6).setCellValue(note.getTags());

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

            try (FileOutputStream outputStream =
                         new FileOutputStream(FILE_PATH)) {

                workbook.write(outputStream);
            }
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