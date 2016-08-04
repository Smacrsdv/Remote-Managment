package com.smacrs.timemanagment.core.entities.lut;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the lut_authority database table.
 * 
 */
@Entity
@Table(name = "lut_authority")
@NamedQuery(name = "LutAuthority.findAll", query = "SELECT l FROM LutAuthority l")
public class LutAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 50)
	private String role;

	public LutAuthority() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}