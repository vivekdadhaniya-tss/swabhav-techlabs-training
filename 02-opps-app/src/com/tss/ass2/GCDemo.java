package com.tss.ass2;

public class GCDemo {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();

        // 1. Check initial memory state
        System.out.println("Initial Total Memory: " + rt.totalMemory() + " bytes");
        System.out.println("Initial Free Memory: " + rt.freeMemory() + " bytes");

        // 2. Create many objects to occupy memory
        for (int i = 0; i < 10000; i++) {
            new String("Garbage Object #" + i);
            // These objects are eligible for GC immediately after creation
            // because they have no reference variable.
        }

        System.out.println("\nMemory after creating 10,000 objects:");
        System.out.println("Free Memory: " + rt.freeMemory() + " bytes");

        // 3. Request Garbage Collection
        System.out.println("\nRequesting Garbage Collection...");
        System.gc();

        // 4. Check memory after GC
        // Note: We delay slightly to give the GC thread a moment to work
        try { Thread.sleep(100); } catch (InterruptedException e) {}

        System.out.println("Free Memory after GC: " + rt.freeMemory() + " bytes");
    }
}
