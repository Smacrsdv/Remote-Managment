package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_task database table.
 * 
 */
@Embeddable
public class UserTaskPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "task_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int taskId;

	@Column(name = "user_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int userId;

	public UserTaskPK() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserTaskPK)) {
			return false;
		}
		UserTaskPK castOther = (UserTaskPK) other;
		return (this.taskId == castOther.taskId) && (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.taskId;
		hash = hash * prime + this.userId;

		return hash;
	}
}