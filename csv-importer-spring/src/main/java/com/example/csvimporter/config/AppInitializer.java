package com.example.csvimporter.config;

import com.example.csvimporter.scheduler.CsvJobScheduler;
import com.example.csvimporter.service.CsvReaderService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

public class AppInitializer implements ServletContextListener {

    private Timer timer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing CSV scheduler...");

        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        CsvReaderService csvService = (CsvReaderService) context.getBean("csvService");

        timer = new Timer();
        timer.schedule(new CsvJobScheduler(csvService), 0,  60 * 1000);

        System.out.println("CSV scheduler started...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down CSV scheduler...");
        if (timer != null) {
            timer.cancel();
        }
    }
}
