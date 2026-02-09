package com.tss.ass1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newScheduledThreadPool();


        executorService.submit(() -> System.out.println("Executor Service test."));
        executorService.submit(() -> System.out.println("Executor Service test2."));

        executorService.shutdown();

    }
}
