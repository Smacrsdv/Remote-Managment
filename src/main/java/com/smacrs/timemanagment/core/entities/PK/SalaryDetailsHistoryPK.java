package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the salary_details_history database table.
 * 
 */
@Embeddable
public class SalaryDetailsHistoryPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "company_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique = true, nullable = false)
	private Date date;

	@Column(name = "user_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int userId;

	public SalaryDetailsHistoryPK() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		if (!(other instanceof SalaryDetailsHistoryPK)) {
			return false;
		}
		SalaryDetailsHistoryPK castOther = (SalaryDetailsHistoryPK) other;
		return (this.companyId == castOther.companyId) && this.date.equals(castOther.date)
				&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.userId;

		return hash;
	}
}