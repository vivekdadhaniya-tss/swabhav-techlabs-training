package com.tss.ass1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Even numbers:");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\nTransformed numbers (square if even, else same):");
        numbers.stream()
                .map(number -> number % 2 == 0 ? number * number : number)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        System.out.println("\nSorted numbers ascending:");
        numbers.stream()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\nSorted numbers descending:");
        numbers.stream()
                .sorted((a, b) -> b - a)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\nFirst 5 numbers (limit):");
        numbers.stream()
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\nSkip first 5 numbers:");
        numbers.stream()
                .skip(5)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("\nFind first number:");
        numbers.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nFind any number:");
        numbers.stream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("\nSum of all numbers:");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("\nCheck if all numbers are positive:");
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println(allPositive);

        System.out.println("\nCheck if any number is even:");
        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println(hasEven);

        System.out.println("\nCheck if no numbers are negative:");
        boolean noNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println(noNegative);
    }
}
