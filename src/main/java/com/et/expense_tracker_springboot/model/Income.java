package com.et.expense_tracker_springboot.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("INCOME")
public class Income extends AbstractTransaction{

    public Income() {
        super();
    }
    public Income(BigDecimal amount, LocalDate date, String description, String category) {
        super(amount, date, description, category);
    }
    @Override
    public BigDecimal getSignedAmount() {
        return getAmount();
    }
}
