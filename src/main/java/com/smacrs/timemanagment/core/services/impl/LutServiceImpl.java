package com.smacrs.timemanagment.core.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.beans.LutBean;
import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;
import com.smacrs.timemanagment.core.services.LutService;
import com.smacrs.timemanagment.core.util.Utils;

/**
 * @author Mohamed265
 */
@Service
@Transactional
public class LutServiceImpl implements LutService {

	@Autowired
	private LutBean lutbean;

	@Override
	public ArrayList<LutAuthority> findAllLutAuthorities() {
		return Utils.convertLutMapToLutList(lutbean.getLutAuthorities());
	}

	@Override
	public synchronized void addLutAuthority(LutAuthority lutAuthority) {
		lutbean.addLutAuthorities(lutAuthority);
	}

	@Override
	public synchronized void removeLutAuthority(LutAuthority lutAuthority) {
		lutbean.removeLutAuthorities(lutAuthority);
	}

	@Override
	public ArrayList<LutTaskStatus> findAllLutTaskStatuss() {
		return Utils.convertLutMapToLutList(lutbean.getLutTaskStatus());
	}

	@Override
	public synchronized void addLutTaskStatus(LutTaskStatus lutTaskStatus) {
		lutbean.addLutTaskStatus(lutTaskStatus);
	}

	@Override
	public synchronized void removeLutTaskStatus(LutTaskStatus lutTaskStatus) {
		lutbean.removeLutTaskStatus(lutTaskStatus);
	}

	@Override
	public ArrayList<LutProjectStatus> findAllLutProjectStatuss() {
		return Utils.convertLutMapToLutList(lutbean.getLutProjectStatus());
	}

	@Override
	public synchronized void addLutProjectStatus(LutProjectStatus lutProjectStatus) {
		lutbean.addLutProjectStatus(lutProjectStatus);
	}

	@Override
	public synchronized void removeLutProjectStatus(LutProjectStatus lutProjectStatus) {
		lutbean.removeLutProjectStatus(lutProjectStatus);
	}

}
