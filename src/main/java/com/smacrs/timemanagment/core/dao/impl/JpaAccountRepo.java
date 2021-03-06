package com.smacrs.timemanagment.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smacrs.timemanagment.core.dao.AccountRepo;
import com.smacrs.timemanagment.core.entities.systementity.Account;

/**
 * Created by Chris on 7/9/14.
 */
@Repository
public class JpaAccountRepo implements AccountRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Account> findAllAccounts() {
		Query query = em.createQuery("SELECT a FROM Account a");
		return query.getResultList();
	}

	@Override
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

	@Autowired
	Account account;
	@Override
	public Account findAccountByName(String name) {
		Query query = em.createQuery("SELECT a FROM Account a,AccountAuthority aa on a.username=?1 join aa.is_granted=1");
		query.setParameter(1, name);
		account.setAuthorities(query.getResultList());
		if (account.getAuthorities().size() == 0) {
			return null;
		} else {
			return account;
		}
	}

	@Override
	public Account createAccount(Account data) {
		em.persist(data);
		return data;
	}
}
