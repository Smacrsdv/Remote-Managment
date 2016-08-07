package com.smacrs.timemanagment.core.entities.lut;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the lut_authority database table.
 * 
 */
@Entity
@Table(name = "lut_authority")
@NamedQuery(name = "LutAuthority.findAllActive", query = "SELECT l FROM LutAuthority l WHERE l.active = true")
public class LutAuthority extends BaseLut {
	private static final long serialVersionUID = 1L;

	public LutAuthority() {
	}

}