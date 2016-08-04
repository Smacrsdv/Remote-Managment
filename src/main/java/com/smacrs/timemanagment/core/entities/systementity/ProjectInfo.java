package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the project_info database table.
 * 
 */
@Entity
@Table(name = "project_info")
@NamedQuery(name = "ProjectInfo.findAll", query = "SELECT p FROM ProjectInfo p")
public class ProjectInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false)
	private int projectId;

	@Column(name = "actual_budget")
	private float actualBudget;

	@Column(name = "actual_delivery_c_date")
	private Date actualDeliveryCDate;

	@Column(name = "actual_delivery_dev_date")
	private Date actualDeliveryDevDate;

	@Column(name = "actual_delivery_qc_date")
	private Date actualDeliveryQcDate;

	@Column(name = "create_date", nullable = false)
	private Date createDate;

	@Column(length = 2000)
	private String description;

	@Column(name = "expected_budget", nullable = false)
	private float expectedBudget;

	@Column(name = "expected_delivery_c_date", nullable = false)
	private Date expectedDeliveryCDate;

	@Column(name = "expected_delivery_dev_date", nullable = false)
	private Date expectedDeliveryDevDate;

	@Column(name = "expected_delivery_qc_date", nullable = false)
	private Date expectedDeliveryQcDate;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	// bi-directional one-to-one association to Project
	@OneToOne
	@JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
	private Project project;

	public ProjectInfo() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public float getActualBudget() {
		return this.actualBudget;
	}

	public void setActualBudget(float actualBudget) {
		this.actualBudget = actualBudget;
	}

	public Date getActualDeliveryCDate() {
		return this.actualDeliveryCDate;
	}

	public void setActualDeliveryCDate(Date actualDeliveryCDate) {
		this.actualDeliveryCDate = actualDeliveryCDate;
	}

	public Date getActualDeliveryDevDate() {
		return this.actualDeliveryDevDate;
	}

	public void setActualDeliveryDevDate(Date actualDeliveryDevDate) {
		this.actualDeliveryDevDate = actualDeliveryDevDate;
	}

	public Date getActualDeliveryQcDate() {
		return this.actualDeliveryQcDate;
	}

	public void setActualDeliveryQcDate(Date actualDeliveryQcDate) {
		this.actualDeliveryQcDate = actualDeliveryQcDate;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getExpectedBudget() {
		return this.expectedBudget;
	}

	public void setExpectedBudget(float expectedBudget) {
		this.expectedBudget = expectedBudget;
	}

	public Date getExpectedDeliveryCDate() {
		return this.expectedDeliveryCDate;
	}

	public void setExpectedDeliveryCDate(Date expectedDeliveryCDate) {
		this.expectedDeliveryCDate = expectedDeliveryCDate;
	}

	public Date getExpectedDeliveryDevDate() {
		return this.expectedDeliveryDevDate;
	}

	public void setExpectedDeliveryDevDate(Date expectedDeliveryDevDate) {
		this.expectedDeliveryDevDate = expectedDeliveryDevDate;
	}

	public Date getExpectedDeliveryQcDate() {
		return this.expectedDeliveryQcDate;
	}

	public void setExpectedDeliveryQcDate(Date expectedDeliveryQcDate) {
		this.expectedDeliveryQcDate = expectedDeliveryQcDate;
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