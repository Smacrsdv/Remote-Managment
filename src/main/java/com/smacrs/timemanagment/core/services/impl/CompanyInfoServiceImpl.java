package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.CompanyInfoRepo;
import com.smacrs.timemanagment.core.entities.systementity.CompanyInfo;
import com.smacrs.timemanagment.core.services.CompanyInfoService;

@Service("CompanyInfoService")
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService {

	@Autowired 
	CompanyInfoRepo companyInfoRepo;
	@Override
	public void CreateCompanyInfo(CompanyInfo companyInfo) {
		companyInfoRepo.CreateCompanyInfo(companyInfo);
		
	}

}
