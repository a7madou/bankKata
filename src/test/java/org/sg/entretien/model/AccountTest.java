package org.sg.entretien.model;


import org.junit.Assert;
import org.junit.Test;
import org.sg.entretien.util.ModelUtil;

import java.math.BigDecimal;


public class AccountTest {


    @Test
    public void depositTest() {
        try {
            Account account = ModelUtil.createAccount();
            account.deposit(new BigDecimal(100));
            Assert.assertEquals(200, account.getBalance().longValue());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode deposit n'est pas implémentée", e.getMessage());
        }
    }


    @Test
    public void withdrawalTest() {
        try {
            Account account = ModelUtil.createAccount();
            account.withdrawal(new BigDecimal(100));
            Assert.assertEquals(0, account.getBalance().longValue());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode withdrawal n'est pas implémentée", e.getMessage());
        }
    }

    @Test
    public void showHistoryTest() {
        try {
            Account account = ModelUtil.createAccount();
            account.showHistory();
            account.deposit(new BigDecimal(100));
            account.deposit(new BigDecimal(200));
            account.withdrawal(new BigDecimal(50));
            Assert.assertEquals(350, account.getBalance().longValue());
            Assert.assertEquals(3, account.getTransactionList().size());
        } catch (RuntimeException e) {
            Assert.assertEquals("la méthode showHistory n'est pas implémentée", e.getMessage());
        }
    }
}
