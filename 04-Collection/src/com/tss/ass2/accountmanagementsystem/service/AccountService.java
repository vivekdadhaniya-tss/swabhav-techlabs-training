package com.tss.ass2.accountmanagementsystem.service;

import com.tss.ass2.accountmanagementsystem.model.Account;
import com.tss.ass2.accountmanagementsystem.model.Transaction;
import com.tss.ass2.accountmanagementsystem.model.TransactionType;

public class AccountService {

    private final TransactionService transactionService;

    public AccountService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public boolean withdraw(Account account, double amount) {
        if (!account.withdraw(amount)) {
            return false;
        }

        recordTransaction(
                account.getAccountNumber(),
                0,
                amount,
                TransactionType.DEBIT
        );
        return true;
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);

        recordTransaction(
                0,
                account.getAccountNumber(),
                amount,
                TransactionType.CREDIT
        );
    }

    public boolean transfer(Account from, Account to, double amount) {
        if (!from.withdraw(amount)) {
            return false;
        }

        to.deposit(amount);

        recordTransaction(
                from.getAccountNumber(),
                to.getAccountNumber(),
                amount,
                TransactionType.TRANSFER
        );
        return true;
    }

    private void recordTransaction(int from, int to, double amount, TransactionType type) {
        transactionService.record(
                new Transaction(from, to, amount, type)
        );
    }
}