package com.smacrs.timemanagment.core.services;

import java.util.ArrayList;

import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;

/**
 * @author Mohamed265
 */
public interface LutService {

	public ArrayList<LutAuthority> findAllLutAuthorities();

	public void addLutAuthority(LutAuthority LutAuthority);

	public void removeLutAuthority(LutAuthority LutAuthority);

	public ArrayList<LutTaskStatus> findAllLutTaskStatuss();

	public void addLutTaskStatus(LutTaskStatus lutTaskStatus);

	public void removeLutTaskStatus(LutTaskStatus lutTaskStatus);

	public ArrayList<LutProjectStatus> findAllLutProjectStatuss();

	public void addLutProjectStatus(LutProjectStatus lutProjectStatus);

	public void removeLutProjectStatus(LutProjectStatus lutProjectStatus);

}
