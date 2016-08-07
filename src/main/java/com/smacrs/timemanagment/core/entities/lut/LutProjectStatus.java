package com.smacrs.timemanagment.core.entities.lut;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the lut_project_status database table.
 * 
 */
@Entity
@Table(name = "lut_project_status")
@NamedQuery(name = "LutProjectStatus.findAllActive", query = "SELECT l FROM LutProjectStatus l WHERE l.active = true")
public class LutProjectStatus extends BaseLut {
	private static final long serialVersionUID = 1L;

	public LutProjectStatus() {
	}

}