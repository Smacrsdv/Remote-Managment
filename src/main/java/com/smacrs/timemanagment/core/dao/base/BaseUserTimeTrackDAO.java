package com.smacrs.timemanagment.core.dao.base;

import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.entities.systementity.User;

public interface BaseUserTimeTrackDAO {
  public  void insert(UserTimeTrack userTimeTrack) ;
  public User Select(String name);
	
	

}
