package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the sprint database table.
 * 
 */
@Entity
@Table(name = "sprint")
@NamedQuery(name = "Sprint.findAll", query = "SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private Boolean active;
//we have to run it as java application to edit that class in DB 
	// no run java app create db from an existing script no crate from entities 
	@Column(name = "end_date", nullable = true)
	private Date endDate;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	// uni-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name = "project_id", nullable = true)
	private Project project;

	public Sprint() {
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}