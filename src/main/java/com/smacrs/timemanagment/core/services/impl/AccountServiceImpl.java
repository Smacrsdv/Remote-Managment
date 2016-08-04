package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.AccountRepo;
import com.smacrs.timemanagment.core.entities.systementity.Account;
import com.smacrs.timemanagment.core.services.AccountService;
import com.smacrs.timemanagment.core.services.exceptions.AccountExistsException;
import com.smacrs.timemanagment.core.services.util.AccountList;

/**
 * Created by Chris on 7/10/14.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Account findAccount(Long id) {
		return accountRepo.findAccount(id);
	}

	@Override
	public Account createAccount(Account data) {
		Account account = accountRepo.findAccountByName(data.getName());
		if (account != null) {
			throw new AccountExistsException();
		}
		return accountRepo.createAccount(data);
	}

	@Override
	public AccountList findAllAccounts() {
		return new AccountList(accountRepo.findAllAccounts());
	}

	@Override
	public Account findByAccountName(String name) {
		return accountRepo.findAccountByName(name);
	}
}
