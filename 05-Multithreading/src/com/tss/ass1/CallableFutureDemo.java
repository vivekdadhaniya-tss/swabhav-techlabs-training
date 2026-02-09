package com.tss.ass1;

import java.util.concurrent.*;

public class CallableFutureDemo {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(5000);
            return 10 + 20;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Doing other work...");

        Integer result = future.get();

        System.out.println("Result = " + result);

        executor.shutdown();
    }
}
