package com.smacrs.timemanagment.core.services.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;
import com.smacrs.timemanagment.core.services.LutService;

@Service
@Transactional
public class LutServiceImpl implements LutService {

	@Override
	public ArrayList<LutAuthority> findAllLutAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLutAuthority(LutAuthority LutAuthority) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLutAuthority(LutAuthority LutAuthority) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<LutTaskStatus> findAllLutTaskStatuss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLutTaskStatus(LutTaskStatus lutTaskStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLutTaskStatus(LutTaskStatus lutTaskStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<LutProjectStatus> findAllLutProjectStatuss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLutProjectStatus(LutProjectStatus lutProjectStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLutProjectStatus(LutProjectStatus lutProjectStatus) {
		// TODO Auto-generated method stub

	}

}
