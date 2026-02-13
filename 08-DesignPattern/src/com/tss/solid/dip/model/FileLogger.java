package com.tss.solid.dip.model;

public class FileLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("Logging to File: " + message);
    }
}
