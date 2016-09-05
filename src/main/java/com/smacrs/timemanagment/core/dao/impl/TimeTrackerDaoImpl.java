package com.smacrs.timemanagment.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.smacrs.timemanagment.core.dao.TimeTrackerDao;
import com.smacrs.timemanagment.core.entities.logicentity.UserTimeTrack;

@Repository("TimeTrackerDao")
public class TimeTrackerDaoImpl implements TimeTrackerDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean saveTimeEntry(UserTimeTrack usertimetrack) {
		try {
			em.persist(usertimetrack);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTimeEntry(UserTimeTrack usertimetrack) {
		try {
			em.merge(usertimetrack);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTimeEntry(int usertimetrackID) {
		try {
			UserTimeTrack u = em.find(UserTimeTrack.class, usertimetrackID);
			em.remove(u);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserTimeTrack getTimeEntry(int usertimetrackID) {
		UserTimeTrack u;
		try {
			u = em.find(UserTimeTrack.class, usertimetrackID);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return u;
	}

	@Override
	public List<UserTimeTrack> getTimeEntries(int userID, int companyID) {
		Query query = em.createNamedQuery("UserTimeTrack.findAllByUserANDCompany");
		return (List<UserTimeTrack>) query.getResultList();
	}

}
