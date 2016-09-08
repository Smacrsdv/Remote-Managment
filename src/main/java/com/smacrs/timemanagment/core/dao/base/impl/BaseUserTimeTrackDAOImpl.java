package com.smacrs.timemanagment.core.dao.base.impl;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smacrs.timemanagment.core.dao.base.BaseUserTimeTrackDAO;
import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.entities.systementity.Sprint;
import com.smacrs.timemanagment.core.entities.systementity.User;

/*@NamedQuery(
	    name="SelectUserByName",
	    query="SELECT * FROM `tm-development`.user where name  LIKE : userName ;"
	)*/

@Repository("BaseUserTimeTrackDAO")
public class BaseUserTimeTrackDAOImpl implements BaseUserTimeTrackDAO {

	
	@PersistenceContext
	private EntityManager em;
/*	@Autowired
	private User user ; */

	
	@Override
	public void insert(UserTimeTrack userTimeTrack) {
		em.persist(userTimeTrack);
		

	}


	@Override
	public User Select(String name) {

		TypedQuery<User> query = em.createQuery(
			      "select u from User u where u.name = :name", User.class);
			    query.setParameter("name", name);
			    return query.getSingleResult();
	
	}

}