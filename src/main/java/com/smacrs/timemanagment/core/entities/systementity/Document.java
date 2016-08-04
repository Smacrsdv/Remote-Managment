package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the documents database table.
 * 
 */
@Entity
@Table(name = "documents")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private byte discriminator;

	@Column(nullable = false, length = 500)
	private String link;

	@Column(name = "upload_date", nullable = false)
	private Date uploadDate;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "uploader_id", nullable = false)
	private User user;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	// uni-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	// uni-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name = "task_id")
	private Task task;

	// uni-directional many-to-one association to Sprint
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	private Sprint sprint;

	public Document() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(byte discriminator) {
		this.discriminator = discriminator;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

}