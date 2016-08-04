package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.lut.LutTaskStatus;

/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@Table(name = "task")
@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false)
	private Boolean active;

	@Column(length = 50)
	private String description;

	@Column(name = "expected_hours", nullable = false)
	private float expectedHours;

	@Column(nullable = false, length = 50)
	private String title;

	// uni-directional many-to-one association to Sprint
	@ManyToOne
	@JoinColumn(name = "sprint_id", nullable = false)
	private Sprint sprint;

	// uni-directional many-to-one association to LutTaskStatus
	@ManyToOne
	@JoinColumn(name = "lut_task_status_id", nullable = false)
	private LutTaskStatus lutTaskStatus;

	public Task() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getExpectedHours() {
		return this.expectedHours;
	}

	public void setExpectedHours(float expectedHours) {
		this.expectedHours = expectedHours;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Sprint getSprint() {
		return this.sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public LutTaskStatus getLutTaskStatus() {
		return this.lutTaskStatus;
	}

	public void setLutTaskStatus(LutTaskStatus lutTaskStatus) {
		this.lutTaskStatus = lutTaskStatus;
	}

}