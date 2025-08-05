package com.example.csvimporter.model;

import java.sql.Timestamp;

public class MeteringReadingInterval {
    private int meterId;
    private Timestamp intervalStart;
    private Timestamp timestamp;
    private int intervalLength;
    private String streamSuffix;
    private int streamNumber;
    private String uom;
    private String quality;
    private String methodFlag;

    public void setMeterId(int meterId) {
        this.meterId = meterId;
    }

    public void setIntervalStart(Timestamp intervalStart) {
        this.intervalStart = intervalStart;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setIntervalLength(int intervalLength) {
        this.intervalLength = intervalLength;
    }

    public void setStreamSuffix(String streamSuffix) {
        this.streamSuffix = streamSuffix;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public void setStreamNumber(int streamNumber) {
        this.streamNumber = streamNumber;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setMethodFlag(String methodFlag) {
        this.methodFlag = methodFlag;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public void setScaled(String scaled) {
        this.scaled = scaled;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getMeterId() {
        return meterId;
    }

    public Timestamp getIntervalStart() {
        return intervalStart;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getValue() {
        return value;
    }

    public String getScaled() {
        return scaled;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public String getMethodFlag() {
        return methodFlag;
    }

    public String getQuality() {
        return quality;
    }

    public String getUom() {
        return uom;
    }

    public int getStreamNumber() {
        return streamNumber;
    }

    public String getStreamSuffix() {
        return streamSuffix;
    }

    public int getIntervalLength() {
        return intervalLength;
    }

    private String reasonCode;
    private String scaled;
    private double value;

}
