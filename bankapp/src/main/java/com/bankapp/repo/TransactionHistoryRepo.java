package com.bankapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.dao.Account;
import com.bankapp.dao.TransactionHistory;
@Repository
public interface TransactionHistoryRepo extends JpaRepository<TransactionHistory, Integer> {

}
