package com.fundoo_notes.batch.batchImport;

import java.io.FileInputStream;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.fundoo_notes.dto.batch.ExcelNoteDTO;
import com.fundoo_notes.repository.NoteRepository;
import com.fundoo_notes.repository.UserRepository;

@Configuration
public class BatchConfig {

	@Bean
	@StepScope
	public ExcelNoteReader excelNoteReader(@Value("#{jobParameters['filePath']}") String filePath) {

		try {

			return new ExcelNoteReader(new FileInputStream(filePath));

		} catch (Exception e) {

			throw new RuntimeException("Unable to read Excel file", e);
		}
	}

	@Bean
	public ExcelNoteProcessor excelNoteProcessor() {

		return new ExcelNoteProcessor();
	}

	@Bean
	@StepScope
	public ItemWriter<ExcelNoteDTO> excelNoteWriter(

			NoteRepository noteRepository, UserRepository userRepository,

			@Value("#{jobParameters['userEmail']}") String userEmail) {

		return new ExcelNoteWriter(noteRepository, userRepository, userEmail);
	}

	@Bean
	public Step importNotesStep(

			JobRepository jobRepository,

			PlatformTransactionManager transactionManager,

			ExcelNoteReader excelNoteReader,

			ExcelNoteProcessor excelNoteProcessor,

			ItemWriter<ExcelNoteDTO> excelNoteWriter) {

		return new StepBuilder("importNotesStep", jobRepository)

				.<ExcelNoteDTO, ExcelNoteDTO>chunk(10, transactionManager)

				.reader(excelNoteReader)

				.processor(excelNoteProcessor)

				.writer(excelNoteWriter)

				.build();
	}

	@Bean
	public Job importNotesJob(

			JobRepository jobRepository,

			Step importNotesStep) {

		return new JobBuilder("importNotesJob", jobRepository)

				.start(importNotesStep)

				.build();
	}
}