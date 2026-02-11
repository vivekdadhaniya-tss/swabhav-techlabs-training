package com.tss.dip.test;

import com.tss.dip.model.FileLogger;
import com.tss.dip.model.Logger;

public class AppService {

    private Logger logger;

    public AppService(Logger logger) {
        this.logger = logger;
    }

    public void performTask(String taskName) throws Exception {
        try {
            System.out.println("Performing task: " + taskName);
            logger.log("Task started: " + taskName);
        } catch (Exception e) {
            System.out.println("Logger failed: " + e.getMessage());
            System.out.println("Switching to fallback logger...");
            Logger fallbackLogger = new FileLogger();
            fallbackLogger.log("Fallback log: Task started: " + taskName);
        }
    }
}
