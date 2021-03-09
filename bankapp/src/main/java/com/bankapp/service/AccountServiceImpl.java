package com.bankapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionHistory;
import com.bankapp.repo.AccountRepo;
@Service
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;

	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountRepo.findById(accountId).orElseThrow(AccountNotFoundException::new);
	}

	@Override
	public Account addAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account updateAccountDetails(int accountId, Account account) {
		Account accountToUpdate=getAccountById(accountId);
		accountToUpdate.setAddress(account.getAddress());
		accountToUpdate.setEmail(account.getEmail());
		accountToUpdate.setPhone(account.getPhone());
		accountRepo.save(accountToUpdate);
		return accountToUpdate;
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account accountToDelete=getAccountById(accountId);
		accountRepo.delete(accountToDelete);
		return accountToDelete;
	}

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		Account fromAcc=getAccountById(fromAccountId);
		Account toAcc=getAccountById(toAccountId);
		fromAcc.setBalance(fromAcc.getBalance()-amount);
		toAcc.setBalance(toAcc.getBalance()+amount);
		toAcc.getHistories().add(new TransactionHistory(fromAccountId, toAccountId, amount, "raj","transfer"));
		fromAcc.getHistories().add(new TransactionHistory(fromAccountId, toAccountId, amount, "raj","transfer"));
		
		accountRepo.save(toAcc);
		accountRepo.save(fromAcc);
		
	}
	/*
	 * TransactionHistory(Integer fromAccount, Integer toAccount, double amount, Date timestamp, 
			String txIniator,
			String txType
	 */

	@Override
	public void deposit(int accountId, double amount) {
		Account depositeAcc=getAccountById(accountId);
		depositeAcc.setBalance(depositeAcc.getBalance()+amount);
		depositeAcc.getHistories().add(new TransactionHistory(0,accountId, amount, "raj","deposit"));
		accountRepo.save(depositeAcc);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account withdrawAcc=getAccountById(accountId);
		withdrawAcc.setBalance(withdrawAcc.getBalance()-amount);
		withdrawAcc.getHistories().add(new TransactionHistory(accountId,0, amount, "raj","withdraw"));
		accountRepo.save(withdrawAcc);
	}

}
