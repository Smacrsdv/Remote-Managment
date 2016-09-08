package com.smacrs.timemanagment.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.CompanyInfoRepo;
import com.smacrs.timemanagment.core.entities.systementity.CompanyInfo;

@Repository("CompanyInfoRepo")
@Transactional
public class JpaCompanyInfoRepo implements CompanyInfoRepo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void CreateCompanyInfo(CompanyInfo companyInfo) {
		em.persist(companyInfo);
	}

}
