package com.smacrs.timemanagment.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.smacrs.timemanagment.core.entities.systementity.Account;
import com.smacrs.timemanagment.rest.mvc.AccountController;
import com.smacrs.timemanagment.rest.resources.AccountResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Chris on 6/28/14.
 */
public class AccountResourceAsm extends ResourceAssemblerSupport<Account, AccountResource> {
	public AccountResourceAsm() {
		super(AccountController.class, AccountResource.class);
	}

	@Override
	public AccountResource toResource(Account account) {
		AccountResource res = new AccountResource();
		res.setName(account.getName());
		res.setPassword(account.getPassword());
		// res.add(linkTo(methodOn(AccountController.class).getAccount(account.getId())).withSelfRel());
		return res;
	}
}
