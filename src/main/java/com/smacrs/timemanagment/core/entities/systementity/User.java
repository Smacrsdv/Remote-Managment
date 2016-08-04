package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 500)
	private String address;

	@Column(name = "cv_link", nullable = false, length = 500)
	private String cvLink;

	@Column(nullable = false, length = 50)
	private String name;

	// uni-directional one-to-one association to Account
	@OneToOne
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	private Account account;

	// uni-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	// uni-directional many-to-many association to Project
	// @ManyToMany
	// @JoinTable(name = "user_project", joinColumns = {
	// @JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
	// @JoinColumn(name = "project_id", nullable = false) })
	// private List<Project> projects;

	// uni-directional many-to-many association to Team
	// @ManyToMany
	// @JoinTable(name = "user_team", joinColumns = {
	// @JoinColumn(name = "user_id", nullable = false) }, inverseJoinColumns = {
	// @JoinColumn(name = "team_id", nullable = false) })
	// private List<Team> teams;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCvLink() {
		return this.cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// public List<Project> getProjects() {
	// return this.projects;
	// }
	//
	// public void setProjects(List<Project> projects) {
	// this.projects = projects;
	// }

	// public List<Team> getTeams() {
	// return this.teams;
	// }
	//
	// public void setTeams(List<Team> teams) {
	// this.teams = teams;
	// }

}