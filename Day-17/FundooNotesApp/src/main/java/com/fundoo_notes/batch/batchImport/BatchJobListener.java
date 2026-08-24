package com.fundoo_notes.batch.batchImport;

import org.springframework.batch.core.job.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class BatchJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {

        System.out.println("====================================");
        System.out.println("Spring Batch Job Started");
        System.out.println("Job Name : " + jobExecution.getJobInstance().getJobName());
        System.out.println("Job ID   : " + jobExecution.getJobInstanceId());
        System.out.println("====================================");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        System.out.println("====================================");
        System.out.println("Spring Batch Job Completed");
        System.out.println("Job Name : " + jobExecution.getJobInstance().getJobName());
        System.out.println("Job ID   : " + jobExecution.getJobInstanceId());
        System.out.println("Status   : " + jobExecution.getStatus());

        if (jobExecution.getStatus().isUnsuccessful()) {
            System.out.println("Batch Job Failed!");

            for (Throwable error : jobExecution.getAllFailureExceptions()) {
                System.out.println("Error : " + error.getMessage());
            }
        } else {
            System.out.println("Batch Job Successfully Completed!");
        }

        System.out.println("====================================");
    }
}