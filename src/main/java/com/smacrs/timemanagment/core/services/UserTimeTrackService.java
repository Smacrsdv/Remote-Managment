package com.smacrs.timemanagment.core.services;

import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.entities.systementity.Sprint;
import com.smacrs.timemanagment.core.entities.systementity.User;

public interface UserTimeTrackService {
	public  void insert(UserTimeTrack userTimeTrack) ;
	 public User Select(String name);
}
