package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.CompanyMonthHourPK;
import com.smacrs.timemanagment.core.entities.systementity.Company;

/**
 * The persistent class for the company_month_hours database table.
 * 
 */
@Entity
@Table(name = "company_month_hours")
@NamedQuery(name = "CompanyMonthHour.findAll", query = "SELECT c FROM CompanyMonthHour c")
public class CompanyMonthHour implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyMonthHourPK id;

	@Column(name = "hours_num", nullable = false)
	private float hoursNum;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private Company company;

	public CompanyMonthHour() {
	}

	public CompanyMonthHourPK getId() {
		return this.id;
	}

	public void setId(CompanyMonthHourPK id) {
		this.id = id;
	}

	public float getHoursNum() {
		return this.hoursNum;
	}

	public void setHoursNum(float hoursNum) {
		this.hoursNum = hoursNum;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}