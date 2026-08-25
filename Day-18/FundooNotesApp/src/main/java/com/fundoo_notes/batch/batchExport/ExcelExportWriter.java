package com.fundoo_notes.batch.batchExport;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.infrastructure.item.Chunk;
import org.springframework.batch.infrastructure.item.ItemWriter;

import com.fundoo_notes.dto.batch.ExportNoteDTO;

public class ExcelExportWriter implements ItemWriter<ExportNoteDTO> {

	private final Workbook workbook;
	private final Sheet sheet;

	private int currentRow = 1;

	private final String filePath;

	public ExcelExportWriter(String filePath) {

		this.filePath = filePath;

		this.workbook = new XSSFWorkbook();

		this.sheet = workbook.createSheet("Notes");

		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("noteId");

		header.createCell(1).setCellValue("title");

		header.createCell(2).setCellValue("description");
	}

	@Override
	public void write(Chunk<? extends ExportNoteDTO> chunk) throws Exception {

		for (ExportNoteDTO dto : chunk.getItems()) {

			Row row = sheet.createRow(currentRow++);

			row.createCell(0).setCellValue(dto.getNoteId());

			row.createCell(1).setCellValue(dto.getTitle());

			row.createCell(2).setCellValue(dto.getDescription());
		}

		saveWorkbook();
	}

	private void saveWorkbook() throws IOException {

		try (FileOutputStream outputStream = new FileOutputStream(filePath)) {

			workbook.write(outputStream);
		}
	}
}