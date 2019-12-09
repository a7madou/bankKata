package org.sg.entretien.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sg.entretien.model.enumeration.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    /* Date of transaction */
    private LocalDateTime transactionDate;

    /* Transaction type */
    private TransactionType transactionType;

    /* amount of transaction*/
    private BigDecimal amount;

}
