package com.tss.PredefinedInterfacesDemo;

import java.util.*;
import java.util.function.*;

public class BiFunctionalDemo {
    public static void main(String[] args) {

        System.out.println("===== BIPREDICATE =====");
        BiPredicate<Integer, Integer> isFirstGreater = (a, b) -> a > b;
        System.out.println(isFirstGreater.test(10, 5)); // true
        System.out.println(isFirstGreater.test(2, 7));  // false

        System.out.println("\n===== BICONSUMER =====");
        BiConsumer<String, Integer> printNameAge = (name, age) -> System.out.println(name + " is " + age + " years old");
        printNameAge.accept("Vivek", 25);
        printNameAge.accept("Jay", 30);

        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        System.out.println("Map iteration using BiConsumer:");
        map.forEach((k,v) -> System.out.println(k + " -> " + v));

        System.out.println("\n===== BIFUNCTION =====");
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + " " + s2;

        System.out.println("Sum: " + sum.apply(5, 10));       // 15
        System.out.println("Concat: " + concat.apply("Hello", "Java")); // Hello Java
    }
}