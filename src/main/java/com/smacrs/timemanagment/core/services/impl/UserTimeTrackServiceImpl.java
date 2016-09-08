package com.smacrs.timemanagment.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.smacrs.timemanagment.core.dao.base.BaseUserTimeTrackDAO;
import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.entities.systementity.Sprint;
import com.smacrs.timemanagment.core.entities.systementity.User;
import com.smacrs.timemanagment.core.services.UserTimeTrackService;

@Service("UserTimeTrackService")
@Transactional
public class UserTimeTrackServiceImpl implements UserTimeTrackService {

	@Autowired
	private BaseUserTimeTrackDAO baseUserTimeTrack;

	
	@Override
	public void insert(UserTimeTrack userTimeTrack) {
		baseUserTimeTrack.insert(userTimeTrack);	
		
	}


	@Override
	public User Select(String name) {
		
		return baseUserTimeTrack.Select(name);
	}

}
