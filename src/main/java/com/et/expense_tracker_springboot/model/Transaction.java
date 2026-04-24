package com.et.expense_tracker_springboot.model;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface Transaction {
    BigDecimal getAmount();
    LocalDate getDate();
    String getCategory();
    String getDescription();
    BigDecimal getSignedAmount();

}
