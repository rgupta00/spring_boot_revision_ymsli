package com.bankapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public List<Account> getAllAccounts() {
		return null;
	}

	@Override
	public Account getAccountById(int accountId) {
		return null;
	}

	@Override
	public Account addAccount(Account account) {
		return null;
	}

	@Override
	public Account updateAccountDetails(int accountId, Account account) {
		return null;
	}

	@Override
	public Account deleteAccount(int accountId) {
		return null;
	}

	@Override
	public void transfer(int fromAccountId, int toAccountId, double amount) {
		
	}

	@Override
	public void deposit(int accountId, double amount) {
	
	}

	@Override
	public void withdraw(int accountId, double amount) {
		
	}

}
