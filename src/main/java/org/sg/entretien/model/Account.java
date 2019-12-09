package org.sg.entretien.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sg.entretien.exception.NegativeAmountException;
import org.sg.entretien.exception.TransactionException;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Account {

    /* Account identifier */
    private int accountNumber;
    /*  list of transactions */
    private List<Transaction> transactionList;
    /* Balance of account */
    private BigDecimal balance;

    public void deposit(BigDecimal amount) throws NegativeAmountException {
        //TODO
        throw new RuntimeException("la méthode deposit n'est pas implémentée");
    }

    public void withdrawal(BigDecimal amount) throws NegativeAmountException, TransactionException {
        //TODO
        throw new RuntimeException("la méthode withdrawal n'est pas implémentée");
    }

    public void showHistory() {
        //TODO
        throw new RuntimeException("la méthode showHistory n'est pas implémentée");
    }
}
