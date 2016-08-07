package com.smacrs.timemanagment.core.entities.lut;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the lut_task_status database table.
 * 
 */
@Entity
@Table(name = "lut_task_status")
@NamedQuery(name = "LutTaskStatus.findAll", query = "SELECT l FROM LutTaskStatus l")
public class LutTaskStatus extends BaseLut {
	private static final long serialVersionUID = 1L;

	public LutTaskStatus() {
	}
}