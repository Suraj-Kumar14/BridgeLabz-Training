package com.fundoo_notes.batch.batchExport;

import com.fundoo_notes.dto.batch.ExportNoteDTO;
import com.fundoo_notes.entity.Note;
import com.fundoo_notes.repository.NoteRepository;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ExportBatchConfig {

	@Bean
	public ItemReader<Note> databaseNoteReader(NoteRepository noteRepository) {

		return new DatabaseNoteReader(noteRepository, "rahul@gmail.com");
	}

	@Bean
	public ItemProcessor<Note, ExportNoteDTO> databaseNoteProcessor() {

		return new DatabaseNoteProcessor();
	}

	@Bean
	public ItemWriter<ExportNoteDTO> excelExportWriter() {

		return new ExcelExportWriter("notes-export.xlsx");
	}

	@Bean
	public Step exportNotesStep(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			ItemReader<Note> databaseNoteReader, ItemProcessor<Note, ExportNoteDTO> databaseNoteProcessor,
			ItemWriter<ExportNoteDTO> excelExportWriter) {

		return new StepBuilder("exportNotesStep", jobRepository)

				.<Note, ExportNoteDTO>chunk(5)

				.reader(databaseNoteReader)

				.processor(databaseNoteProcessor)

				.writer(excelExportWriter)

				.transactionManager(transactionManager)

				.build();
	}

	@Bean
	public Job exportNotesJob(JobRepository jobRepository, Step exportNotesStep) {

		return new JobBuilder("exportNotesJob", jobRepository)

				.start(exportNotesStep)

				.build();
	}
}