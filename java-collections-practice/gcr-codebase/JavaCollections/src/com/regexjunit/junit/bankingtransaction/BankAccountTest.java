package com.regexjunit.junit.bankingtransaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exception.banktransactionsystem.InsufficientBalanceException;

class BankAccountTest {

	BankAccount account;
	@BeforeEach
	void setUp() throws Exception {
		account=new BankAccount(10000);
	}

	@Test
	void testDeposit() {
		account.deposit(5000);
		assertEquals(15000,account.getBalance());
	}

	@Test
	void testWithdraw() throws InsufficientBalanceException {
		account.withdraw(5000);
		assertEquals(5000,account.getBalance());
	}

	@Test
	void testWithdrawInsufficientFunds() {
		try {
			account.withdraw(20000);
			fail("Exception should have been thrown");
		}catch(InsufficientBalanceException e) {
			assertEquals("Insufficient Balance.", e.getMessage());
		}
	}

}
