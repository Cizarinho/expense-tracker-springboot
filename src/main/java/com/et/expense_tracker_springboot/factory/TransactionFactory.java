package com.et.expense_tracker_springboot.factory;

import com.et.expense_tracker_springboot.model.Expense;
import com.et.expense_tracker_springboot.model.Income;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.et.expense_tracker_springboot.model.Transaction;

@Component
public class TransactionFactory {

    public Transaction createTransaction(String type,BigDecimal amount,LocalDate date,String category, String description) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Transaktionstyp darf nicht leer sein!");
        }
        if ("INCOME".equalsIgnoreCase(type)) {
            return new Income(amount,date,category,description);
        } else if ("EXPENSE".equalsIgnoreCase(type)) {
            return new Expense(amount,date,category,description);
        } else  {
            throw new IllegalArgumentException("Unbekannter Transaktionstyp:" + type + ". Erlaubt sind nur INCOME or EXPENSE!");
        }
    }
}
