package org.sg.entretien.model;


import org.junit.Assert;
import org.junit.Test;
import org.sg.entretien.exception.NegativeAmountException;
import org.sg.entretien.exception.TransactionException;
import org.sg.entretien.util.ModelUtil;

import java.math.BigDecimal;


public class AccountTest {


    @Test
    public void deposit_positive_amount_Test() throws NegativeAmountException {
        try {
            Account account = ModelUtil.createAccount();
            account.deposit(new BigDecimal(100));
            Assert.assertEquals(200, account.getBalance().longValue());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode deposit n'est pas implémentée", e.getMessage());
        }
    }

    @Test(expected = NegativeAmountException.class)
    public void deposit_negative_amount_Test() throws NegativeAmountException {
        try {
            Account account = ModelUtil.createAccount();
            account.deposit(new BigDecimal(-50));
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode deposit n'est pas implémentée", e.getMessage());
        }
    }

    @Test
    public void withdrawal_positive_amount_Test() throws NegativeAmountException, TransactionException {
        try {
            Account account = ModelUtil.createAccount();
            account.withdrawal(new BigDecimal(100));
            Assert.assertEquals(0, account.getBalance().longValue());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode withdrawal n'est pas implémentée", e.getMessage());
        }
    }

    @Test(expected = NegativeAmountException.class)
    public void withdrawal_negative_amount_Test() throws NegativeAmountException, TransactionException {
        try {
            Account account = ModelUtil.createAccount();
            account.withdrawal(new BigDecimal(-50));
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode withdrawal n'est pas implémentée", e.getMessage());
        }
    }

    @Test(expected = TransactionException.class)
    public void withdrawal_amount_greater__balance_Test() throws NegativeAmountException, TransactionException {
        try {
            Account account = ModelUtil.createAccount();
            account.withdrawal(new BigDecimal(200));
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode withdrawal n'est pas implémentée", e.getMessage());
        }
    }

    @Test
    public void showHistoryTest() throws NegativeAmountException, TransactionException {
        try {
            Account account = ModelUtil.createAccount();
            account.deposit(new BigDecimal(100));
            account.deposit(new BigDecimal(200));
            account.withdrawal(new BigDecimal(50));
            account.showHistory();
            Assert.assertEquals(350, account.getBalance().longValue());
            Assert.assertEquals(3, account.getTransactionList().size());
            Assert.assertEquals("DEPOSIT | 100", account.getTransactionList().get(0).toString());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode showHistory n'est pas implémentée", e.getMessage());
        }
    }
}
