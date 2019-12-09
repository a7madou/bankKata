package org.sg.entretien.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sg.entretien.constant.TransactionConstant;
import org.sg.entretien.exception.NegativeAmountException;
import org.sg.entretien.exception.TransactionException;
import org.sg.entretien.model.enumeration.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
            Transaction transaction = new Transaction(LocalDateTime.now(), TransactionType.DEPOSIT, amount);
            transactionList.add(transaction);
        } else {
            throw new NegativeAmountException(TransactionConstant.NEGATIVE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public void withdrawal(BigDecimal amount) throws NegativeAmountException, TransactionException {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            if (balance.compareTo(amount) < 0) {
                throw new TransactionException(TransactionConstant.INSUFFICIENT_ERROR_MESSAGE);
            }
            balance = balance.subtract(amount);
            Transaction transaction = new Transaction(LocalDateTime.now(), TransactionType.WITHDRAWAL, amount);
            transactionList.add(transaction);
        } else {
            throw new NegativeAmountException(TransactionConstant.NEGATIVE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public void showHistory() {
        transactionList.forEach(System.out::println);
    }
}
