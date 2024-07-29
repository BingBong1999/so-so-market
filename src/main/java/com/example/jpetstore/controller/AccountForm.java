package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Account;

@SuppressWarnings("serial")
public class AccountForm implements Serializable {

	private Account account;
	private boolean newAccount;
	private String repeatedPassword;

	public AccountForm(Account account) {
		this.account = account;
		this.newAccount = false;
	}

	public AccountForm() {
		this.account = new Account();
		this.newAccount = true;
	}

	public Account getAccount() {
		return account;
	}

	public boolean isNewAccount() {
		return newAccount;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	@Override
	public String toString() {
		return "AccountForm [account=" + account + ", newAccount=" + newAccount + ", repeatedPassword="
				+ repeatedPassword + "]";
	}
}