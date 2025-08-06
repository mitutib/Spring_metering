package com.example.csvimporter.dao;


import com.example.csvimporter.model.MeteringReadingInterval;
import org.springframework.jdbc.core.JdbcTemplate;

public class MeteringReadingIntervalDAO {
    private JdbcTemplate jdbcTemplate;

    public MeteringReadingIntervalDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(MeteringReadingInterval reading) {
        String sql = "INSERT INTO bbeng_metering_reading_intervals " +
                "(meter_id, interval_start, timestamp, interval_length, stream_suffix, stream_number, uom, quality, method_flag, reason_code, scaled, value) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                reading.getMeterId(),
                reading.getIntervalStart(),
                reading.getTimestamp(),
                reading.getIntervalLength(),
                reading.getStreamSuffix(),
                reading.getStreamNumber(),
                reading.getUom(),
                reading.getQuality(),
                reading.getMethodFlag(),
                reading.getReasonCode(),
                reading.getScaled(),
                reading.getValue());
    }
}
