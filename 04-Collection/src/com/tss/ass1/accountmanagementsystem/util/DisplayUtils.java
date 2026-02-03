package com.tss.ass1.accountmanagementsystem.util;

import com.tss.ass1.accountmanagementsystem.model.Account;
import com.tss.ass1.accountmanagementsystem.model.Transaction;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DisplayUtils {

    private static final DecimalFormat MONEY = new DecimalFormat("#,##0.00");
    private static final DateTimeFormatter DATE_TIME =
            DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");

    /* ================= ACCOUNTS ================= */

    public static void printAllAccounts(List<Account> accounts) {

        System.out.println("\n========================= ALL ACCOUNTS =========================");
        System.out.printf("%-10s %-15s %-12s %-12s%n",
                "AccNo", "Name", "Type", "Balance");

        System.out.println("---------------------------------------------------------------");

        for (Account acc : accounts) {
            System.out.printf("%-10d %-15s %-12s %12s%n",
                    acc.getAccountNumber(),
                    capitalize(acc.getName()),
                    acc.getAccountType(),
                    MONEY.format(acc.getBalance()));
        }

        System.out.println("===============================================================\n\n");
    }

    public static void printAccountDetails(Account acc) {

        System.out.println("\n====================== ACCOUNT DETAILS =======================");
        System.out.println("Account Number : " + acc.getAccountNumber());
        System.out.println("Name           : " + capitalize(acc.getName()));
        System.out.println("Account Type   : " + acc.getAccountType());
        System.out.println("Balance        : " + MONEY.format(acc.getBalance()));
        System.out.println("==============================================================\n\n");
    }

    /* ================= TRANSACTIONS ================= */

    public static void printTransactions(List<Transaction> transactions) {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n===================== TRANSACTION HISTORY =====================");
        System.out.printf(
                "%-8s %-10s %-10s %14s %-12s %-20s%n",
                "TxnID", "FromAcc", "ToAcc", "Amount", "Type", "Date & Time"
        );


        System.out.println("---------------------------------------------------------------");

        for (Transaction tx : transactions) {

            String from = tx.getFromAccount() == 0 ? "-" : String.valueOf(tx.getFromAccount());
            String to   = tx.getToAccount() == 0 ? "-" : String.valueOf(tx.getToAccount());

            System.out.printf(
                    "%-8d %-10s %-10s %14s %-12s %-20s%n",
                    tx.getTransactionId(),
                    from,
                    to,
                    MONEY.format(tx.getAmount()),
                    tx.getType(),
                    tx.getTimestamp().format(DATE_TIME)
            );

        }

        System.out.println("===============================================================\n\n");
    }

    /* ================= HELPERS ================= */

    private static String capitalize(String name) {
        if (name == null || name.isBlank()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
