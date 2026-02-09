package com.tss.ass1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() ->
                System.out.println("Task 1 : " + Thread.currentThread().getName()));
        executor.submit(() ->
                System.out.println("Task 2 : " + Thread.currentThread().getName()));

        executor.shutdown();
    }
}
