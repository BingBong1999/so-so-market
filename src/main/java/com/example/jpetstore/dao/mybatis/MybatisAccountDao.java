package com.example.jpetstore.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.mybatis.mapper.AccountMapper;
import com.example.jpetstore.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;

	public Account getAccount(String accountId) throws DataAccessException {
		return accountMapper.getAccount(accountId);
	}

	public Account getAccountLogIn(String accountId, String password) throws DataAccessException {
		return accountMapper.getAccountLogIn(accountId, password);
	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}

	public void deleteAccount(String accountId) throws DataAccessException {
		accountMapper.deleteAccount(accountId);
	}

	public void updateWithdraw(String accountId) throws DataAccessException {
		accountMapper.updateWithdraw(accountId);
	}
}