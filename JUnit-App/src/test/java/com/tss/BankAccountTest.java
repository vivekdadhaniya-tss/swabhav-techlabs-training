package com.tss;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount("Vivek", 1000.0);
    }

    @BeforeAll
    static void initAll() {
        System.out.println("Starting BankAccount tests...");
    }

    @Test
    void deposit() {
        double newBalance = account.deposit(500);
        assertTrue(newBalance == 1500.0);
        assertFalse(newBalance < 1500.0);
    }

    @Test
    void withdraw() {
        double newBalance = account.withdraw(500);
        assertTrue(newBalance == 500.0);
        assertFalse(newBalance < 1000.0);
    }

    @Test
    void depositeNegativeAmountTest() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-500));
    }

    @Test
    void AccountObjTest() {
        Object obj = account;
        assertInstanceOf(BankAccount.class, obj);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests completed!");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Bye bye...");
    }

}