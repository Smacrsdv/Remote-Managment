package com.smacrs.timemanagment.core.services;

import com.smacrs.timemanagment.core.entities.Account;
import com.smacrs.timemanagment.core.services.util.AccountList;

/**
 * Created by Chris on 6/28/14.
 */
public interface AccountService {
	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public AccountList findAllAccounts();

	public Account findByAccountName(String name);
}
