package com.et.expense_tracker_springboot.repository;
import com.et.expense_tracker_springboot.model.AbstractTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<AbstractTransaction, Long> {

    List<AbstractTransaction> findAllByOrderByDateDesc();
}
