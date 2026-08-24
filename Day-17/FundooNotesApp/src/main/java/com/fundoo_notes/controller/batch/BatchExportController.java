package com.fundoo_notes.controller.batch;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.fundoo_notes.service.batch.ExportBatchService;

@RestController
@RequestMapping("/api/batch")
public class BatchExportController {

    private final ExportBatchService exportBatchService;

    public BatchExportController(
            ExportBatchService exportBatchService) {

        this.exportBatchService =
                exportBatchService;
    }

    @GetMapping("/notes/export")
    public ResponseEntity<String> exportNotes() {

        try {

            exportBatchService.exportNotes();

            return ResponseEntity.ok(
                    "Notes exported successfully. " +
                    "Check notes-export.xlsx");

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .body(
                        "Export failed: "
                        + e.getMessage());
        }
    }
}