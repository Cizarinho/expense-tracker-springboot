package com.et.expense_tracker_springboot.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("EXPENSE")
public class Expense extends AbstractTransaction {
    public Expense() {
        super();
    }
    public Expense(BigDecimal amount, LocalDate date, String description, String category) {
        super(amount, date, description, category);
    }
    @Override
    public BigDecimal getSignedAmount() {
        return getAmount().negate();
    }
}
