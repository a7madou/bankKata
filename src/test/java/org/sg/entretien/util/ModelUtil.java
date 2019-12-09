package org.sg.entretien.util;


import org.sg.entretien.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Creation de donnees de test
 */
public class ModelUtil {


    public static Account createAccount() {
        Account account = new Account();
        account.setAccountNumber(20081988);
        account.setBalance(new BigDecimal(100));
        account.setTransactionList(new ArrayList<>());
        return account;
    }


}