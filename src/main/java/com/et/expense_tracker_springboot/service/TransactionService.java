package com.et.expense_tracker_springboot.service;

import com.et.expense_tracker_springboot.factory.TransactionFactory;
import com.et.expense_tracker_springboot.model.AbstractTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.et.expense_tracker_springboot.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final TransactionFactory factory;

    @Autowired
    public TransactionService(TransactionRepository repository, TransactionFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //Neue Transaktion erstellen und Speichern
    public void addTransaction(String type, BigDecimal amount, LocalDate date, String category, String description) {
        var transaction = (AbstractTransaction) factory.createTransaction(type, amount, date, category, description);

        repository.save(transaction);
    }
    public List<AbstractTransaction> getAllTransactions() {
        return repository.findAllByOrderByDateDesc();
    }
    // Kontostand berechnen
    public BigDecimal calculateBalance() {
        List<AbstractTransaction> all = repository.findAll();
        BigDecimal balance = BigDecimal.ZERO;
        for (var tx : all) {
            balance = balance.add(tx.getSignedAmount());
        }
        return balance;
    }
}
