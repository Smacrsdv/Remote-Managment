package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.dao.UserRepo;
import com.smacrs.timemanagment.core.entities.systementity.User;
import com.smacrs.timemanagment.core.services.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public void CreateUser(User user) {
		userRepo.CreateUser(user);
		
	}

}
