package com.smacrs.timemanagment.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.smacrs.timemanagment.core.services.util.AccountList;
import com.smacrs.timemanagment.rest.mvc.AccountController;
import com.smacrs.timemanagment.rest.resources.AccountListResource;
import com.smacrs.timemanagment.rest.resources.AccountResource;

import java.util.List;

/**
 * Created by Chris on 7/22/14.
 */
public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
