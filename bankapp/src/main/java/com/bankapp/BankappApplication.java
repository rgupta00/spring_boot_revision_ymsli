package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {


	@Autowired
	private AccountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Account account=new Account(name, balance, email, address, phone, accountType)
//		Account account=new Account("aman", 1000.0, "a@aman.com", "delhi", "5645454545", "saving");
//		Account account2=new Account("suman", 1000.0, "s@aman.com", "noida", "5045454545", "saving");
//		
//		accountService.addAccount(account);
//		accountService.addAccount(account2);
//		
//		accountService.transfer(1, 2, 100);
//		accountService.deposit(1, 50);
//		accountService.withdraw(2, 50);
		
	}

	
}
