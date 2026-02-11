package com.tss.dip.model;

public class DBLogger implements Logger {

    private boolean simulateFailure;

    public DBLogger(boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }

    @Override
    public void log(String message) throws Exception {
        if (simulateFailure) {
            throw new Exception("DB connection failed!");
        }
        System.out.println("Logging to DB: " + message);
    }
}
