/**
 * Date Aug 7, 2016 12:07:40 PM
 * Author: Mohamed265
 */
package com.smacrs.timemanagment.core.beans;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;

import com.smacrs.timemanagment.core.dao.base.LutDAO;
import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;
import com.smacrs.timemanagment.core.util.Utils;

/**
 * @author Mohamed265
 *
 */
@ApplicationScope
public class LutBean {

	// TODO EXTEND BASE BEAN

	@Autowired
	private HashMap<Integer, LutAuthority> lutAuthorities;

	@Autowired
	private HashMap<Integer, LutProjectStatus> lutProjectStatuss;

	@Autowired
	private HashMap<Integer, LutTaskStatus> lutTaskStatuss;

	@Autowired
	private LutDAO lutdao;

	@PostConstruct
	private void init() {
		System.out.println("LutService init " + System.currentTimeMillis());
		
		lutAuthorities = Utils.convertLutListToLutMap(lutdao.findAllLutAuthorities());

		lutProjectStatuss = Utils.convertLutListToLutMap(lutdao.findAllLutProjectStatuss());

		lutTaskStatuss = Utils.convertLutListToLutMap(lutdao.findAllLutTaskStatuss());
		
		System.out.println("LutService done " + System.currentTimeMillis());
	}

	public void addLutAuthorities(LutAuthority lutAuthority) {
		try {
			lutdao.addEntity(lutAuthority);
			lutAuthorities.put(lutAuthority.getId(), lutAuthority);
		} catch (HibernateException e) {
			return;
		}
	}

	public void addLutProjectStatus(LutProjectStatus lutProjectStatus) {
		try {
			lutdao.addEntity(lutProjectStatus);
			lutProjectStatuss.put(lutProjectStatus.getId(), lutProjectStatus);
		} catch (HibernateException e) {
			return;
		}
	}

	public void addLutTaskStatus(LutTaskStatus lutTaskStatus) {
		try {
			lutdao.addEntity(lutTaskStatus);
			lutTaskStatuss.put(lutTaskStatus.getId(), lutTaskStatus);
		} catch (HibernateException e) {
			return;
		}
	}

	public void removeLutAuthorities(LutAuthority lutAuthority) {
		try {
			lutdao.removeLutAuthority(lutAuthority);
			lutAuthorities.remove(lutAuthority.getId());
		} catch (HibernateException e) {
			return;
		}
	}

	public void removeLutProjectStatus(LutProjectStatus lutProjectStatus) {
		try {
			lutdao.removeLutProjectStatus(lutProjectStatus);
			lutProjectStatuss.remove(lutProjectStatus.getId());
		} catch (HibernateException e) {
			return;
		}
	}

	public void removeLutTaskStatus(LutTaskStatus lutTaskStatus) {
		try {
			lutdao.removeLutTaskStatus(lutTaskStatus);
			this.lutTaskStatuss.remove(lutTaskStatus.getId());
		} catch (HibernateException e) {
			return;
		}
	}

	public HashMap<Integer, LutAuthority> getLutAuthorities() {
		return lutAuthorities;
	}

	public HashMap<Integer, LutProjectStatus> getLutProjectStatus() {
		return lutProjectStatuss;
	}

	public HashMap<Integer, LutTaskStatus> getLutTaskStatus() {
		return lutTaskStatuss;
	}

}
