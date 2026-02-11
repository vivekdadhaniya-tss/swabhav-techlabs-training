package com.tss.dip.test;

import com.tss.dip.model.DBLogger;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("=== Test with DBLogger Success ===");
        AppService service1 = new AppService(new DBLogger(false)); // DBLogger works
        service1.performTask("Process Order");

        System.out.println("\n=== Test with DBLogger Failure ===");
        AppService service2 = new AppService(new DBLogger(true)); // Simulate DB failure
        service2.performTask("Process Payment");

    }
}