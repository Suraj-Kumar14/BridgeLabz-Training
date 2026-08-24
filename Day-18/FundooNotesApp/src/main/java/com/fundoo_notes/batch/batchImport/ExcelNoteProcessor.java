package com.fundoo_notes.batch.batchImport;

import org.springframework.batch.infrastructure.item.ItemProcessor;

import com.fundoo_notes.dto.batch.ExcelNoteDTO;

public class ExcelNoteProcessor implements ItemProcessor<ExcelNoteDTO, ExcelNoteDTO> {

	@Override
	public ExcelNoteDTO process(ExcelNoteDTO item) {

		if (item.getTitle() == null || item.getTitle().trim().isEmpty()) {

			return null;
		}

		item.setTitle(item.getTitle().trim());

		if (item.getDescription() != null) {
			item.setDescription(item.getDescription().trim());
		}

		return item;
	}
}