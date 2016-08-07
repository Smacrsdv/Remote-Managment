package com.smacrs.timemanagment.core.dao;

import java.util.List;

import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;

public interface TimeTrackerDao {

	public boolean saveTimeEntry(UserTimeTrack usertimetrack);

	public boolean updateTimeEntry(UserTimeTrack usertimetrack);

	public boolean deleteTimeEntry(int usertimetrackID);

	public UserTimeTrack getTimeEntry(int usertimetrackID);

	public List<UserTimeTrack> getTimeEntries(int userID, int companyID);
}
