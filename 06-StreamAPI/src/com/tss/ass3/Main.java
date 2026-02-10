package com.tss.ass3;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account(101, "Jayesh", 5000),
                new Account(102, "Nimesh", 7000),
                new Account(103, "Mark", 3000),
                new Account(104, "Mahesh", 10000),
                new Account(105, "Ramesh", 8000)
        );

        System.out.println("Account with minimum balance:");
        accounts.stream()
                .min(Comparator.comparingDouble(Account::getAmount))
                .ifPresent(System.out::println);

        System.out.println("\nAccount with maximum balance:");
        accounts.stream()
                .max(Comparator.comparingDouble(Account::getAmount))
                .ifPresent(System.out::println);

        System.out.println("\nAccounts with name greater than 6 letters:");
        accounts.stream()
                .filter(account -> account.getName().length() > 6)
                .forEach(System.out::println);

        double totalBalance = accounts.stream()
                .mapToDouble(Account::getAmount)
                .sum();
        System.out.println("\nTotal balance of all accounts: " + totalBalance);

//        double totalBalance2  = accounts.stream()
//                .map(Account::getAmount)
//                .reduce(0.0, Double::sum);

        double totalBalance3 = accounts.stream()
                .reduce(0.0,
                        (sum, acc) -> sum + acc.getAmount(),
                        Double::sum);

    }
}
