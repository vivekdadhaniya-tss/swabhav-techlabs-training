package com.tss.ass2.accountmanagementsystem.service;

import com.tss.ass2.accountmanagementsystem.model.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionService {

    private final List<Transaction> allTransactions = new ArrayList<>();

    public void record(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        allTransactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return Collections.unmodifiableList(allTransactions);
    }

    public List<Transaction> getTransactionForAccount(int accountNumber) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction tx : allTransactions) {
            if (isRelatedToAccount(tx, accountNumber)) {
                transactions.add(tx);
            }
        }
        return transactions;
    }

    private boolean isRelatedToAccount(Transaction tx, int accountNumber) {
        return tx.getFromAccount() == accountNumber
                || tx.getToAccount() == accountNumber;
    }
}