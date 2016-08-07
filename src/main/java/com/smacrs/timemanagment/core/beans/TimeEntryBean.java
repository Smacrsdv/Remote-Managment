package com.smacrs.timemanagment.core.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;
import com.smacrs.timemanagment.core.services.TimeTrackerService;

@ApplicationScope
public class TimeEntryBean extends BaseBean {

	@Autowired
	public List<UserTimeTrack> usersTimeTrackList;

	@Autowired
	public TimeTrackerService timeTrackerService;

	public void addStartTimeEntry(UserTimeTrack usertimetrack) {
		if (usersTimeTrackList == null)
			usersTimeTrackList = new ArrayList<UserTimeTrack>();

		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			usertimetrack.setDate(sdf.parse(sdf.format(new Date())));
			usertimetrack.setStartTime(new Date());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		usersTimeTrackList.add(usertimetrack);
	}

	public void addStopTimeEntry(UserTimeTrack usertimetrack) {
		if (usersTimeTrackList == null)
			usersTimeTrackList = new ArrayList<UserTimeTrack>();

		// String ss = "2016-08-07 10:35:21", ee = "2016-08-07 11:55:21";
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date s = usertimetrack.getStartTime();
		Date e = new Date();

		long diff = e.getTime() - s.getTime();
		long diffMinutes = diff / (60 * 1000);

		usertimetrack.setTotalMinutes((int) diffMinutes);
		usertimetrack.setEndTime(new Date());

		// save to db
		timeTrackerService.saveTimeEntry(usertimetrack);
		// delete from list
		deleteTimeEntry(usertimetrack.getUser().getId(), usertimetrack.getCompany().getId());
	}

	public void deleteTimeEntry(UserTimeTrack usertimetrack) {
		usersTimeTrackList.remove(usertimetrack);
	}

	public void deleteTimeEntry(int userID, int companyID) {
		usersTimeTrackList.removeIf(p -> p.getUser().getId() == userID && p.getCompany().getId() == companyID);
	}

	public UserTimeTrack getTimeEntry(int userID, int companyID) {
		for (UserTimeTrack u : usersTimeTrackList) {
			if (u.getUser().getId() == userID && u.getCompany().getId() == companyID)
				return u;
		}
		return null;
	}

	public List<UserTimeTrack> getTimeEntries(int userID, int companyID) {
		List<UserTimeTrack> result = new ArrayList<>();
		for (UserTimeTrack u : usersTimeTrackList) {
			if (u.getUser().getId() == userID && u.getCompany().getId() == companyID)
				result.add(u);
		}
		return result;
	}
}
