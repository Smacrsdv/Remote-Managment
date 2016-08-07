package com.smacrs.timemanagment.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smacrs.timemanagment.core.dao.TimeTrackerDao;
import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.services.TimeTrackerService;

public class TimeTrackerServiceImpl implements TimeTrackerService {

	@Autowired
	public TimeTrackerDao timeTrackerDao;

	@Override
	public boolean saveTimeEntry(UserTimeTrack usertimetrack) {
		return timeTrackerDao.saveTimeEntry(usertimetrack);
	}

	@Override
	public boolean updateTimeEntry(UserTimeTrack usertimetrack) {
		return timeTrackerDao.updateTimeEntry(usertimetrack);
	}

	@Override
	public boolean deleteTimeEntry(int usertimetrackID) {
		return timeTrackerDao.deleteTimeEntry(usertimetrackID);
	}

	@Override
	public UserTimeTrack getTimeEntry(int usertimetrackID) {
		return timeTrackerDao.getTimeEntry(usertimetrackID);
	}

	@Override
	public List<UserTimeTrack> getTimeEntries(int userID, int companyID) {
		return timeTrackerDao.getTimeEntries(userID, companyID);
	}

}
