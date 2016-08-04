package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.CalenderPK;

/**
 * The persistent class for the calender database table.
 * 
 */
@Entity
@Table(name = "calender")
@NamedQuery(name = "Calender.findAll", query = "SELECT c FROM Calender c")
public class Calender implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalenderPK id;

	@Column(name = "hours_num", nullable = false)
	private float hoursNum;

	@Column(name = "is_holiday")
	private Boolean isHoliday;

	@Column(length = 2000)
	private String json;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private Company company;

	public Calender() {
	}

	public CalenderPK getId() {
		return this.id;
	}

	public void setId(CalenderPK id) {
		this.id = id;
	}

	public float getHoursNum() {
		return this.hoursNum;
	}

	public void setHoursNum(float hoursNum) {
		this.hoursNum = hoursNum;
	}

	public Boolean getIsHoliday() {
		return this.isHoliday;
	}

	public void setIsHoliday(Boolean isHoliday) {
		this.isHoliday = isHoliday;
	}

	public String getJson() {
		return this.json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}