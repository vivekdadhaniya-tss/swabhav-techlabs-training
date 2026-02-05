package com.tss.ass4.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
