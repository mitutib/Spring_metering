package com.example.csvimporter.scheduler;


import com.example.csvimporter.service.CsvReaderService;

import java.util.TimerTask;

public class CsvJobScheduler extends TimerTask {
    private final CsvReaderService csvReaderService;

    public CsvJobScheduler(CsvReaderService service) {
        this.csvReaderService = service;
    }

    @Override
    public void run() {
        csvReaderService.readAndStore("C:\\Users\\Mitu Tiberiu\\Desktop\\Spring_metering_reading_intervals\\csv-importer-spring\\data.csv");
    }
}
