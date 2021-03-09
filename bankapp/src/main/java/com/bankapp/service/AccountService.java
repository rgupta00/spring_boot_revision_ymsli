package com.bankapp.service;
import java.util.*;

import com.bankapp.dao.Account;
public interface AccountService {
	//mgr
	public List<Account> getAllAccounts();
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	public Account updateAccountDetails(int accountId, Account account);
	public Account deleteAccount(int accountId);
	
	//clerk
	public void transfer(int fromAccountId, int toAccountId, double amount);
	public void deposit(int accountId,double amount);
	public void withdraw(int accountId,double amount);
	
	
	
}
