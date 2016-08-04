package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the calender database table.
 * 
 */
@Embeddable
public class CalenderPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="company_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int companyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique=true, nullable=false)
	private java.util.Date date;

	public CalenderPK() {
	}
	public int getCompanyId() {
		return this.companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CalenderPK)) {
			return false;
		}
		CalenderPK castOther = (CalenderPK)other;
		return 
			(this.companyId == castOther.companyId)
			&& this.date.equals(castOther.date);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.date.hashCode();
		
		return hash;
	}
}