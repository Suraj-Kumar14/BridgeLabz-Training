package com.fundoo_notes.controller.batch;


import org.springframework.batch.core.job.JobExecution;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.fundoo_notes.service.batch.ExcelBatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    private final ExcelBatchService excelBatchService;

    public BatchController(
            ExcelBatchService excelBatchService) {

        this.excelBatchService = excelBatchService;
    }

    @PostMapping("/notes/import")
    public ResponseEntity<?> importNotes(

            @RequestParam("file")
            MultipartFile file,

            Authentication authentication) {

        if (file.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("Excel file is required");
        }

        if (!file.getOriginalFilename()
                .toLowerCase()
                .endsWith(".xlsx")) {

            return ResponseEntity.badRequest()
                    .body("Only .xlsx files are allowed");
        }

        String userEmail =
                authentication.getName();

        JobExecution execution =
                excelBatchService.importNotes(
                        file,
                        userEmail);

        return ResponseEntity.ok(
                "Excel import started. Job ID: "
                        + execution.getJobInstanceId());
    }
}