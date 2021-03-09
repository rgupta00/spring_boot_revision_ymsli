package com.bankapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;
	private String name;
	private Double balance;
	private String email;
	private String address;
	private String phone;
	private String accountType;

	@JoinColumn(name = "acc_id")
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	
	private List<TransactionHistory> histories = new ArrayList<>();

	public List<TransactionHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<TransactionHistory> histories) {
		this.histories = histories;
	}

	public Account() {
	}

	public Account(String name, Double balance, String email, String address, String phone, String accountType) {
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.accountType = accountType;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
