package com.smacrs.timemanagment.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.UserRepo;
import com.smacrs.timemanagment.core.entities.systementity.User;

@Repository("UserRepo")
@Transactional
public class JpaUserRepo implements UserRepo {

	@PersistenceContext
	EntityManager em ;
	
	@Override
	public void CreateUser(User user) {
		em.persist(user);
		
	}

}
