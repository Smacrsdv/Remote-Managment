package com.smacrs.timemanagment.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.CompanyRepo;
import com.smacrs.timemanagment.core.entities.systementity.Company;

@Repository("CompanyRepo")
@Transactional
public class JpaCompanyRepo implements CompanyRepo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void CreateCompany(Company company) {
		em.persist(company);
		
	}

}
