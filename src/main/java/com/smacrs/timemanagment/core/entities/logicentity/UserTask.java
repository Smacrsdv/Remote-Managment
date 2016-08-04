package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.smacrs.timemanagment.core.entities.PK.UserTaskPK;
import com.smacrs.timemanagment.core.entities.systementity.Task;
import com.smacrs.timemanagment.core.entities.systementity.User;

/**
 * The persistent class for the user_task database table.
 * 
 */
@Entity
@Table(name = "user_task")
@NamedQuery(name = "UserTask.findAll", query = "SELECT u FROM UserTask u")
public class UserTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserTaskPK id;

	@Column(name = "total_work_time", nullable = false)
	private int totalWorkTime;

	// uni-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name = "task_id", nullable = false, insertable = false, updatable = false)
	private Task task;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private User user;

	public UserTask() {
	}

	public UserTaskPK getId() {
		return this.id;
	}

	public void setId(UserTaskPK id) {
		this.id = id;
	}

	public int getTotalWorkTime() {
		return this.totalWorkTime;
	}

	public void setTotalWorkTime(int totalWorkTime) {
		this.totalWorkTime = totalWorkTime;
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