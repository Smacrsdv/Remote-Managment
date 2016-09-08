package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.DepartmentRepo;
import com.smacrs.timemanagment.core.entities.systementity.Department;
import com.smacrs.timemanagment.core.services.DepartmentService;


@Service("DepartmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepo departmentRepo;
	
	@Override
	public void createDepartment(Department department) {
		
		departmentRepo.CreateDepatment(department);
	}

}
