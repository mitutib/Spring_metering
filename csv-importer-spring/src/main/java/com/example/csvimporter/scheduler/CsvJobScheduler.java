package com.example.csvimporter.scheduler;

import com.example.csvimporter.service.CsvImportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CsvJobScheduler {

    private final CsvImportService importService;

    public CsvJobScheduler(CsvImportService importService) {
        this.importService = importService;
    }

    @Scheduled(fixedRate = 30000)
    public void runCsvImportJob() {
        importService.importCsv("meter_readings.csv");
    }
}
