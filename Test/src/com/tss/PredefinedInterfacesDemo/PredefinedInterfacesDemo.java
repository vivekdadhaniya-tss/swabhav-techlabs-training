package com.tss.PredefinedInterfacesDemo;

import java.util.*;
import java.util.function.*;

public class PredefinedInterfacesDemo {

    public static void main(String[] args) {

        System.out.println("===== PREDICATE =====");
        // Predicate: check a condition → returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("10 is even? " + isEven.test(10)); // true
        System.out.println("-5 is positive? " + isPositive.test(-5)); // false

        // Predicate chaining: and, or, negate
        Predicate<Integer> positiveAndEven = isPositive.and(isEven);
        System.out.println("8 is positive and even? " + positiveAndEven.test(8)); // true
        System.out.println("8 is not positive? " + isPositive.negate().test(8)); // false



        System.out.println("\n===== CONSUMER =====");
        // Consumer: take input, perform action → no return
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        Consumer<String> printLower = s -> System.out.println(s.toLowerCase());

        // Basic usage
        printUpper.accept("Java"); // JAVA
        printLower.accept("Java"); // java

        // Chaining consumers
        printUpper.andThen(printLower).accept("Lambda");
        // Output:
        // LAMBDA
        // lambda



        System.out.println("\n===== SUPPLIER =====");
        // Supplier: provides a value → no input
        Supplier<Double> randomValue = () -> Math.random();
        Supplier<String> greetSupplier = () -> "Hello Java";

        System.out.println("Random Value: " + randomValue.get());
        System.out.println(greetSupplier.get());

        // Supplier for object creation
        Supplier<List<String>> listSupplier = ArrayList::new; // using method reference
        List<String> myList = listSupplier.get();
        myList.add("Apple");
        myList.add("Banana");
        System.out.println("List from Supplier: " + myList);



        System.out.println("\n===== FUNCTION =====");
        // Function: transform input to output
        Function<Integer, Integer> square = n -> n * n;
        Function<String, Integer> stringLength = s -> s.length();

        System.out.println("Square of 5: " + square.apply(5)); // 25
        System.out.println("Length of 'Vivek': " + stringLength.apply("Vivek")); // 5

        // Function chaining: andThen, compose
        Function<Integer, Integer> multiplyBy2 = n -> n * 2;
        Function<Integer, Integer> add10 = n -> n + 10;

        System.out.println("Multiply by 2 then add 10 (5): " + multiplyBy2.andThen(add10).apply(5)); // 20
        System.out.println("Add 10 then multiply by 2 (5): " + multiplyBy2.compose(add10).apply(5)); // 30

        System.out.println("\n===== ADVANCED USAGE WITH COLLECTIONS =====");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Using Predicate to filter
        System.out.print("Even numbers: ");
        numbers.stream().filter(isEven).forEach(n -> System.out.print(n + " ")); // 2 4 6
        System.out.println();

        // Using Consumer to print
        System.out.print("Numbers: ");
        numbers.forEach(n -> System.out.print(n + " ")); // 1 2 3 4 5 6
        System.out.println();

        // Using Function to map
        System.out.print("Square of numbers: ");
        numbers.stream().map(square).forEach(n -> System.out.print(n + " ")); // 1 4 9 16 25 36
        System.out.println();

        // Using Supplier for lazy initialization
        Supplier<Map<String, Integer>> mapSupplier = HashMap::new;
        Map<String, Integer> map = mapSupplier.get();
        map.put("Apple", 10);
        map.put("Banana", 20);
        System.out.println("Map from Supplier: " + map);
    }
}