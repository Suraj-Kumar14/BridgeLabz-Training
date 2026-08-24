package com.fundoo_notes.batch.batchImport;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.batch.infrastructure.item.ItemReader;

import com.fundoo_notes.dto.batch.ExcelNoteDTO;

import java.io.InputStream;

public class ExcelNoteReader implements ItemReader<ExcelNoteDTO> {

    private final Workbook workbook;
    private final Sheet sheet;

    private int currentRow = 1;

    public ExcelNoteReader(InputStream inputStream) throws Exception {

        this.workbook = WorkbookFactory.create(inputStream);
        this.sheet = workbook.getSheetAt(0);
    }

    @Override
    public ExcelNoteDTO read() {

        if (currentRow > sheet.getLastRowNum()) {
            return null;
        }

        Row row = sheet.getRow(currentRow++);

        if (row == null) {
            return read();
        }

        String title = getCellValue(row.getCell(0));
        String description = getCellValue(row.getCell(1));

        return new ExcelNoteDTO(title, description);
    }

    private String getCellValue(Cell cell) {

        if (cell == null) {
            return "";
        }

        return switch (cell.getCellType()) {

            case STRING -> cell.getStringCellValue();

            case NUMERIC -> String.valueOf(cell.getNumericCellValue());

            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());

            case FORMULA -> cell.getCellFormula();

            case BLANK -> "";

            default -> "";
        };
    }
}