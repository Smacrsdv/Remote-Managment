package com.smacrs.timemanagment.rest.mvc;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smacrs.timemanagment.core.entities.Account;
import com.smacrs.timemanagment.core.services.AccountService;
import com.smacrs.timemanagment.core.services.exceptions.AccountExistsException;
import com.smacrs.timemanagment.core.services.util.AccountList;
import com.smacrs.timemanagment.rest.exceptions.ConflictException;
import com.smacrs.timemanagment.rest.exceptions.ForbiddenException;
import com.smacrs.timemanagment.rest.resources.AccountListResource;
import com.smacrs.timemanagment.rest.resources.AccountResource;
import com.smacrs.timemanagment.rest.resources.asm.AccountListResourceAsm;
import com.smacrs.timemanagment.rest.resources.asm.AccountResourceAsm;

/**
 * Created by Chris on 6/28/14.
 */
@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<AccountListResource> findAllAccounts(
			@RequestParam(value = "name", required = false) String name) {
		AccountList list = null;
		if (name == null) {
			list = accountService.findAllAccounts();
		} else {
			Account account = accountService.findByAccountName(name);
			if (account == null) {
				list = new AccountList(new ArrayList<Account>());
			} else {
				list = new AccountList(Arrays.asList(account));
			}
		}
		AccountListResource res = new AccountListResourceAsm().toResource(list);
		return new ResponseEntity<AccountListResource>(res, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource sentAccount) {
		try {
			Account createdAccount = accountService.createAccount(sentAccount.toAccount());
			AccountResource res = new AccountResourceAsm().toResource(createdAccount);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(res.getLink("self").getHref()));
			return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
		} catch (AccountExistsException exception) {
			throw new ConflictException(exception);
		}
	}

	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
	public ResponseEntity<AccountResource> getAccount(@PathVariable Long accountId) {
		Account account = accountService.findAccount(accountId);
		if (account != null) {
			AccountResource res = new AccountResourceAsm().toResource(account);
			return new ResponseEntity<AccountResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<AccountResource>(HttpStatus.NOT_FOUND);
		}
	}

	private void d(int accountId) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails details = (UserDetails) principal;
			Account loggedIn = accountService.findByAccountName(details.getUsername());
			if (loggedIn.getId() == accountId) {

			} else {
				throw new ForbiddenException();
			}
		} else {
			throw new ForbiddenException();
		}
	}

}
