package com.fundoo_notes.service.batch;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
public class ExportBatchService {

    private final JobLauncher jobLauncher;

    private final Job exportNotesJob;

    public ExportBatchService(
            JobLauncher jobLauncher,
            Job exportNotesJob) {

        this.jobLauncher = jobLauncher;
        this.exportNotesJob = exportNotesJob;
    }

    public JobExecution exportNotes()
            throws Exception {

        JobParameters parameters =
                new JobParametersBuilder()

                        .addLong(
                                "timestamp",
                                System.currentTimeMillis())

                        .toJobParameters();

        return jobLauncher.run(
                exportNotesJob,
                parameters);
    }
}