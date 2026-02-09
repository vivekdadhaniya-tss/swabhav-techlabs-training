package com.tss.ass1;

import java.util.concurrent.*;

public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {

        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(1);

        executor.schedule(() ->
                        System.out.println("Task executed after delay - " +
                                Thread.currentThread().getName()),
                3,
                TimeUnit.SECONDS);

        executor.shutdown();
    }
}
