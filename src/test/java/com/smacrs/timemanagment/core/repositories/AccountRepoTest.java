package com.smacrs.timemanagment.core.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.AccountRepo;
import com.smacrs.timemanagment.core.entities.Account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Chris on 7/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/application-config.xml")
public class AccountRepoTest {

	@Autowired
	private AccountRepo repo;

	private Account account;

	@Before
	@Transactional
	@Rollback(false)
	public void setup() {
		account = new Account();
		account.setName("name");
		account.setPassword("password");
		repo.createAccount(account);
	}

	@Test
	@Transactional
	public void testFind() {
		Account account = repo.findAccount(this.account.getId());
		assertNotNull(account);
		assertEquals(account.getName(), "name");
		assertEquals(account.getPassword(), "password");
	}
}
