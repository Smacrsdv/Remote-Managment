/**
 * Date Aug 7, 2016 12:04:48 PM
 * Author: Mohamed265
 */
package com.smacrs.timemanagment.core.dao.base;

import java.util.List;

import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;
import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;

/**
 * @author Mohamed265
 *
 */
public interface LutDAO extends BaseDAO {

	public List<LutAuthority> findAllLutAuthorities();

	public void addLutAuthority(LutAuthority LutAuthority);

	public void removeLutAuthority(LutAuthority LutAuthority);

	public List<LutTaskStatus> findAllLutTaskStatuss();

	public void addLutTaskStatus(LutTaskStatus lutTaskStatus);

	public void removeLutTaskStatus(LutTaskStatus lutTaskStatus);

	public List<LutProjectStatus> findAllLutProjectStatuss();

	public void addLutProjectStatus(LutProjectStatus lutProjectStatus);

	public void removeLutProjectStatus(LutProjectStatus lutProjectStatus);
}
