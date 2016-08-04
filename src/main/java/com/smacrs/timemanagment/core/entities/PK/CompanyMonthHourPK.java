package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the company_month_hours database table.
 * 
 */
@Embeddable
public class CompanyMonthHourPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "company_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique = true, nullable = false)
	private java.util.Date month;

	public CompanyMonthHourPK() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public java.util.Date getMonth() {
		return this.month;
	}

	public void setMonth(java.util.Date month) {
		this.month = month;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanyMonthHourPK)) {
			return false;
		}
		CompanyMonthHourPK castOther = (CompanyMonthHourPK) other;
		return (this.companyId == castOther.companyId) && this.month.equals(castOther.month);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.month.hashCode();

		return hash;
	}
}