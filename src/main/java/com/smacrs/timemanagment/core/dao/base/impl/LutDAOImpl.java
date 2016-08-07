/**
 * Date Aug 7, 2016 12:05:37 PM
 * Author: Mohamed265
 */
package com.smacrs.timemanagment.core.dao.base.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.smacrs.timemanagment.core.dao.base.LutDAO;
import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;

/**
 * @author Mohamed265
 *
 */
public class LutDAOImpl extends BaseDAOImpl implements LutDAO {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LutAuthority> findAllLutAuthorities() {
		return getResultList("LutAuthority.findAllActive");
	}

	@Override
	public void addLutAuthority(LutAuthority lutAuthority) {
		addEntity(lutAuthority);

	}

	@Override
	public void removeLutAuthority(LutAuthority lutAuthority) {
		lutAuthority.setActive(false);
		updateEntity(lutAuthority);
	}

	@Override
	public List<LutTaskStatus> findAllLutTaskStatuss() {
		return getResultList("LutTaskStatus.findAllActive");
	}

	@Override
	public void addLutTaskStatus(LutTaskStatus lutTaskStatus) {
		addEntity(lutTaskStatus);

	}

	@Override
	public void removeLutTaskStatus(LutTaskStatus lutTaskStatus) {
		lutTaskStatus.setActive(false);
		updateEntity(lutTaskStatus);
	}

	@Override
	public List<LutProjectStatus> findAllLutProjectStatuss() {
		return getResultList("LutProjectStatus.findAllActive");
	}

	@Override
	public void addLutProjectStatus(LutProjectStatus lutProjectStatus) {
		addEntity(lutProjectStatus);
	}

	@Override
	public void removeLutProjectStatus(LutProjectStatus lutProjectStatus) {
		lutProjectStatus.setActive(false);
		updateEntity(lutProjectStatus);
	}

}
