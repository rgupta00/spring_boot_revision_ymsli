package com.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionHistory;
@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer> {

}
