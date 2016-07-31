package com.smacrs.timemanagment.core.dao;

import java.util.List;

import com.smacrs.timemanagment.core.entities.Account;

/**
 * Created by Chris on 7/9/14.
 */
public interface AccountRepo {
	public List<Account> findAllAccounts();

	public Account findAccount(Long id);

	public Account findAccountByName(String name);

	public Account createAccount(Account data);
}
