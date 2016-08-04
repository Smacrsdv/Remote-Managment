package com.smacrs.timemanagment.core.entities.lut;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the lut_project_status database table.
 * 
 */
@Entity
@Table(name = "lut_project_status")
@NamedQuery(name = "LutProjectStatus.findAll", query = "SELECT l FROM LutProjectStatus l")
public class LutProjectStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	public LutProjectStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}