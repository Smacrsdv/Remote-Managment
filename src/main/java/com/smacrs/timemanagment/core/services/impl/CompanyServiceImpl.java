package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.CompanyRepo;
import com.smacrs.timemanagment.core.entities.systementity.Company;
import com.smacrs.timemanagment.core.services.CompanyService;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
    
	@Autowired
	CompanyRepo companyRepo;
	
	@Override
	public void CreateCompany(Company company) {
	companyRepo.CreateCompany(company);	
		
	}
	

}
