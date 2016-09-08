package com.smacrs.timemanagment.core.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.DepartmentRepo;
import com.smacrs.timemanagment.core.entities.systementity.Department;

@Repository("DepartmentRepo")
@Transactional
public class JpaDepartmentRepo implements DepartmentRepo{

	@PersistenceContext
	EntityManager em ;
	
	
	@Override
	public void CreateDepatment(Department department) {
		
		em.persist(department);
		
	}
	
	

}
