package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name = "department")
@NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private Boolean active;

	@Column(nullable = false, length = 50)
	private String name;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	public Department() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}