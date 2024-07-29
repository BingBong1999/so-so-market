package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;

public interface AccountDao {
	Account getAccount(String accountId) throws DataAccessException;

	Account getAccountLogIn(String accountId, String password) throws DataAccessException;

	void insertAccount(Account account) throws DataAccessException;

	void updateAccount(Account account) throws DataAccessException;

	void deleteAccount(String accountId) throws DataAccessException;

	void updateWithdraw(String accountId) throws DataAccessException;
}