package com.example.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
	BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }
    
    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(ArithmeticException.class, () -> {
            account.withdraw(1500);
        });
    }

    @Test
    void testGetBalance() {
        assertEquals(1000, account.getBalance());
    }
}
