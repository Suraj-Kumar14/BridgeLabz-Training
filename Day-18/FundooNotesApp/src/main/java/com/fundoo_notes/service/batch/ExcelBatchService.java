package com.fundoo_notes.service.batch;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ExcelBatchService {

    private final JobLauncher jobLauncher;
    private final Job importNotesJob;

    public ExcelBatchService(
            JobLauncher jobLauncher,
            Job importNotesJob) {

        this.jobLauncher = jobLauncher;
        this.importNotesJob = importNotesJob;
    }

    public JobExecution importNotes(
            MultipartFile file,
            String userEmail) {

        try {

            Path uploadDirectory =
                    Path.of("uploads");

            Files.createDirectories(uploadDirectory);

            Path filePath =
                    uploadDirectory.resolve(
                            file.getOriginalFilename());

            file.transferTo(filePath);

            JobParameters jobParameters =
                    new JobParametersBuilder()

                            .addString(
                                    "filePath",
                                    filePath.toAbsolutePath()
                                            .toString())

                            .addString(
                                    "userEmail",
                                    userEmail)

                            .addLong(
                                    "timestamp",
                                    System.currentTimeMillis())

                            .toJobParameters();

            return jobLauncher.run(
                    importNotesJob,
                    jobParameters);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Excel import failed", e);
        }
    }
}