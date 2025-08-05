package com.example.csvimporter.dao;

import com.example.csvimporter.model.MeteringReadingInterval;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeteringReadingIntervalDao {

    private final JdbcTemplate jdbcTemplate;

    public MeteringReadingIntervalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAll(List<MeteringReadingInterval> intervals) {
        String sql = "INSERT INTO bbeng_metering_reading_intervals " +
                "(meter_id, interval_start, timestamp, interval_length, stream_suffix, stream_number, uom, quality, method_flag, reason_code, scaled, value) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        for (MeteringReadingInterval i : intervals) {
            jdbcTemplate.update(sql,
                    i.getMeterId(),
                    i.getIntervalStart(),
                    i.getTimestamp(),
                    i.getIntervalLength(),
                    i.getStreamSuffix(),
                    i.getStreamNumber(),
                    i.getUom(),
                    i.getQuality(),
                    i.getMethodFlag(),
                    i.getReasonCode(),
                    i.getScaled(),
                    i.getValue()
            );
        }
    }
}
