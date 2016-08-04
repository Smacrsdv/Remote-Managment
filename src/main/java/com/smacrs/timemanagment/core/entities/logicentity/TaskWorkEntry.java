package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.systementity.Task;
import com.smacrs.timemanagment.core.entities.systementity.User;

import java.util.Date;

/**
 * The persistent class for the task_work_entry database table.
 * 
 */
@Entity
@Table(name = "task_work_entry")
@NamedQuery(name = "TaskWorkEntry.findAll", query = "SELECT t FROM TaskWorkEntry t")
public class TaskWorkEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private String id;

	private int duration;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	// uni-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false)
	private Task task;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public TaskWorkEntry() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}