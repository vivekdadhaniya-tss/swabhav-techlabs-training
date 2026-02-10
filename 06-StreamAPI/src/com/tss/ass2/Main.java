package com.tss.ass2;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh"};

//        System.out.println("First 3 names sorted alphabetically:");
//        Stream.of(names)
//                .sorted()
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("\n");
//
//        System.out.println("First 3 names containing 'a' sorted alphabetically:");
//        Stream.of(names)
//                .filter(name -> name.toLowerCase().contains("a"))
//                .sorted()
//                .limit(3)
//                .forEach(System.out::println);
//
//        System.out.println("\n");
//
//        System.out.println("Names sorted in descending order:");
//        Stream.of(names)
//                .sorted(Comparator.reverseOrder())
////                .sorted((s1,s2) -> s2.compareTo(s1))
//                .forEach(System.out::println);
//
//        System.out.println("\n");
//
//        System.out.println("First 3 letters of all names:");
//        Stream.of(names)
//                .map(name -> name.substring(0,3))
//                .forEach(System.out::println);
//
//        System.out.println("\n");
//
//        System.out.println("Names with length <= 4:");
//        Stream.of(names)
//                .filter(name -> name.length() <= 4)
//                .forEach(System.out::println);

        Stream.of(names)
                .peek(System.out::println)
                .filter(name -> name.toLowerCase().contains("a"))
                .peek(System.out::println)
                .sorted()
                .peek(System.out::println)
                .limit(3)
                .forEach(System.out::println);
    }
}
