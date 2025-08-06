package com.example.csvimporter;

import com.example.csvimporter.scheduler.CsvJobScheduler;
import com.example.csvimporter.service.CsvReaderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CsvReaderService csvService = (CsvReaderService) context.getBean("csvService");

        Timer timer = new Timer();
        timer.schedule(new CsvJobScheduler(csvService), 0, 60 * 60 * 1000);

        System.out.println("CSV scheduler started...");
    }
}
