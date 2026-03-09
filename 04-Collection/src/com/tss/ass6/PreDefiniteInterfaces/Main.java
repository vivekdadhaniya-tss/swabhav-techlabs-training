package com.tss.ass6.PreDefiniteInterfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // Predicate Interface
        Predicate<Integer> isOdd = number -> number % 2 != 0;
        System.out.println(isOdd.test(5));

        // BiFunctional Interface
        BiFunction<Integer, Integer, Integer> addition = (number1, number2) -> number1 + number2;
        System.out.println(addition.apply(10, 20));

        // Consumer Interface
        Consumer<List<Integer>> printNumbers = list -> {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
        };
        printNumbers.accept(List.of(1, 2, 3, 4, 5));

        Consumer<Integer> sqrNumber = number -> System.out.println(number * number);
        sqrNumber.accept(5);

        // Supplier Interface
        Supplier<LocalDate> getDate = () -> LocalDate.now();
        System.out.println(getDate.get());


        // UnaryOperator Interface
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println(square.apply(5)); // 25

        // BinaryOperator Interface
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30
    }
}
