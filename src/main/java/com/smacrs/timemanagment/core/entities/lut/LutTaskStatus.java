package com.smacrs.timemanagment.core.entities.lut;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the lut_task_status database table.
 * 
 */
@Entity
@Table(name = "lut_task_status")
@NamedQuery(name = "LutTaskStatus.findAll", query = "SELECT l FROM LutTaskStatus l")
public class LutTaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 50)
	private String name;

	public LutTaskStatus() {
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