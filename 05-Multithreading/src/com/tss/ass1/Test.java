package com.tss.ass1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            int number = i + 10;
            tasks.add(() -> {
//                Thread.sleep(5000);
               System.out.println(Thread.currentThread().getName() + ": " + number);
               return number;
           });

        }

        List<Future<Integer>> futures = executor.invokeAll(tasks);

        System.out.println("\n\n");

//        System.out.println("\n--- Results ---");
//        for (Future<Integer> future : futures) {
//            System.out.println(future.get());
//        }

        System.out.println(executor.invokeAny(tasks));

        executor.shutdown();
    }
}
