package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.lut.LutProjectStatus;

import java.util.List;

/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@Table(name = "project")
@NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private Boolean active;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String nickname;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	// uni-directional many-to-one association to LutProjectStatus
	@ManyToOne
	@JoinColumn(name = "project_status_id", nullable = false)
	private LutProjectStatus lutProjectStatus;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "project_manager_id", nullable = false)
	private User user;

	// uni-directional many-to-many association to Department
	// @ManyToMany
	// @JoinTable(name = "project_department", joinColumns = {
	// @JoinColumn(name = "project_id", nullable = false) }, inverseJoinColumns
	// = {
	// @JoinColumn(name = "department_id", nullable = false) })
	// private List<Department> departments;

	// bi-directional one-to-one association to ProjectInfo
	@OneToOne(mappedBy = "project")
	private ProjectInfo projectInfo;

	public Project() {
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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public LutProjectStatus getLutProjectStatus() {
		return this.lutProjectStatus;
	}

	public void setLutProjectStatus(LutProjectStatus lutProjectStatus) {
		this.lutProjectStatus = lutProjectStatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public List<Department> getDepartments() {
	// return this.departments;
	// }
	//
	// public void setDepartments(List<Department> departments) {
	// this.departments = departments;
	// }

	public ProjectInfo getProjectInfo() {
		return this.projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

}