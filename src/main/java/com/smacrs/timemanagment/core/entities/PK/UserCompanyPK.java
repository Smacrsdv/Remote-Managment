package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_company database table.
 * 
 */
@Embeddable
public class UserCompanyPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "company_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int companyId;

	@Column(name = "user_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int userId;

	public UserCompanyPK() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
		if (!(other instanceof UserCompanyPK)) {
			return false;
		}
		UserCompanyPK castOther = (UserCompanyPK) other;
		return (this.companyId == castOther.companyId) && (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.userId;

		return hash;
	}
}