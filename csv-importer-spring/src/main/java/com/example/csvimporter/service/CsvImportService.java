package com.example.csvimporter.service;

import com.example.csvimporter.dao.MeteringReadingIntervalDao;
import com.example.csvimporter.model.MeteringReadingInterval;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvImportService {

    private final MeteringReadingIntervalDao dao;

    public CsvImportService(MeteringReadingIntervalDao dao) {
        this.dao = dao;
    }

    public void importCsv(String filePath) {
        try (CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT)) {
            List<MeteringReadingInterval> list = new ArrayList<>();
            for (CSVRecord record : parser) {
                MeteringReadingInterval m = new MeteringReadingInterval();
                m.setMeterId(Integer.parseInt(record.get(0)));
                m.setIntervalStart(Timestamp.valueOf(record.get(1)));
                m.setTimestamp(Timestamp.valueOf(record.get(2)));
                m.setIntervalLength(Integer.parseInt(record.get(3)));
                m.setStreamSuffix(record.get(4));
                m.setStreamNumber(Integer.parseInt(record.get(5)));
                m.setUom(record.get(6));
                m.setQuality(record.get(7));
                m.setMethodFlag(record.get(8));
                m.setReasonCode(record.get(9));
                m.setScaled(record.get(10));
                m.setValue(Double.parseDouble(record.get(11)));
                list.add(m);
            }
            dao.saveAll(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
