package com.bankapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	private Integer fromAccount;
	private Integer toAccount;
	private double amount;
	private Date timestamp;
	private String txIniator;
	private String txType;// deposit, withdraw, transfer


	public TransactionHistory(Integer fromAccount, Integer toAccount, double amount, 
			String txIniator,
			String txType) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.timestamp = new Date();
		this.txIniator = txIniator;
		this.txType = txType;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public TransactionHistory() {
	}

	

	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Integer getToAccount() {
		return toAccount;
	}

	public void setToAccount(Integer toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getTxIniator() {
		return txIniator;
	}

	public void setTxIniator(String txIniator) {
		this.txIniator = txIniator;
	}

}
