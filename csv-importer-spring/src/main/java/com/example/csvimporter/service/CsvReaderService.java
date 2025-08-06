package com.example.csvimporter.service;


import com.example.csvimporter.dao.MeteringReadingIntervalDAO;
import com.example.csvimporter.model.MeteringReadingInterval;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CsvReaderService {
    private final MeteringReadingIntervalDAO dao;

    public CsvReaderService(MeteringReadingIntervalDAO dao) {
        this.dao = dao;
    }

    public void readAndStore(String filePath) {
        String line;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                MeteringReadingInterval mri = new MeteringReadingInterval();
                mri.setMeterId(Integer.parseInt(tokens[0]));
                mri.setIntervalStart(Timestamp.valueOf(LocalDateTime.parse(tokens[1], formatter)));
                mri.setTimestamp(Timestamp.valueOf(LocalDateTime.parse(tokens[2], formatter)));
                mri.setIntervalLength(Integer.parseInt(tokens[3]));
                mri.setStreamSuffix(tokens[4]);
                mri.setStreamNumber(Integer.parseInt(tokens[5]));
                mri.setUom(tokens[6]);
                mri.setQuality(tokens[7]);
                mri.setMethodFlag(tokens[8].isEmpty() ? null : tokens[8]);
                mri.setReasonCode(tokens[9].isEmpty() ? null : tokens[9]);
                mri.setScaled(tokens[10]);
                mri.setValue(Double.parseDouble(tokens[11]));

                dao.save(mri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
