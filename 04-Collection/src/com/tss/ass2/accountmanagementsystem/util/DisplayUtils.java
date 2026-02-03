package com.tss.ass2.accountmanagementsystem.util;

import com.tss.ass2.accountmanagementsystem.model.Account;
import com.tss.ass2.accountmanagementsystem.model.Transaction;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DisplayUtils {

    private static final DecimalFormat MONEY =
            new DecimalFormat("#,##0.00");

    private static final DateTimeFormatter DATE_TIME =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");

    /* ================= ACCOUNTS ================= */

    public static void printAllAccounts(List<Account> accounts) {

        if (accounts.isEmpty()) {
            System.out.println("\nNo accounts available.\n");
            return;
        }

        printHeading("ALL ACCOUNTS");

        printLine(65);
        System.out.printf("| %-10s | %-18s | %-12s | %15s |%n",
                "Acc No", "Name", "Type", "Balance");
        printLine(65);

        for (Account acc : accounts) {
            System.out.printf("| %-10d | %-18s | %-12s | %15s |%n",
                    acc.getAccountNumber(),
                    capitalize(acc.getName()),
                    acc.getAccountType(),
                    MONEY.format(acc.getBalance()));
        }

        printLine(65);
        System.out.println();
    }

    public static void printAccountDetails(Account acc) {

        printHeading("ACCOUNT DETAILS");

        printLine(45);
        System.out.printf("| %-20s : %-18s |%n", "Account Number", acc.getAccountNumber());
        System.out.printf("| %-20s : %-18s |%n", "Name", capitalize(acc.getName()));
        System.out.printf("| %-20s : %-18s |%n", "Account Type", acc.getAccountType());
        System.out.printf("| %-20s : %-18s |%n", "Balance", MONEY.format(acc.getBalance()));
        printLine(45);
        System.out.println();
    }

    /* ================= TRANSACTIONS ================= */

    public static void printTransactions(List<Transaction> transactions) {

        if (transactions.isEmpty()) {
            System.out.println("\nNo transaction history found.\n");
            return;
        }

        printHeading("TRANSACTION HISTORY");

        printLine(95);
        System.out.printf("| %-6s | %-10s | %-10s | %14s | %-10s | %-20s |%n",
                "TxnID", "FromAcc", "ToAcc", "Amount", "Type", "Date & Time");
        printLine(95);

        for (Transaction tx : transactions) {

            String from = tx.getFromAccount() == 0 ? "-" : String.valueOf(tx.getFromAccount());
            String to   = tx.getToAccount() == 0 ? "-" : String.valueOf(tx.getToAccount());

            System.out.printf("| %-6d | %-10s | %-10s | %14s | %-10s | %-20s |%n",
                    tx.getTransactionId(),
                    from,
                    to,
                    MONEY.format(tx.getAmount()),
                    tx.getType(),
                    tx.getTimestamp().format(DATE_TIME));
        }

        printLine(95);
        System.out.println();
    }

    /* ================= HELPERS ================= */

    private static void printHeading(String title) {
        System.out.println("\n" + "=".repeat(100));
        System.out.printf("%50s%n", title);
        System.out.println("=".repeat(100));
    }

    private static void printLine(int length) {
        System.out.println("-".repeat(length));
    }

    private static String capitalize(String name) {
        if (name == null || name.isBlank()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
