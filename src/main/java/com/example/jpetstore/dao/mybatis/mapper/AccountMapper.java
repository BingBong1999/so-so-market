package com.example.jpetstore.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

import com.example.jpetstore.domain.Account;

public interface AccountMapper {

	Account getAccount(String accountId);

	Account getAccountLogIn(@Param("accountId") String accountId, @Param("password") String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	void deleteAccount(String accountId);

	void updateWithdraw(String accountId);

}