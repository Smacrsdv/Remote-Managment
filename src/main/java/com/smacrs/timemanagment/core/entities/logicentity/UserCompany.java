package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.UserCompanyPK;
import com.smacrs.timemanagment.core.entities.systementity.Company;
import com.smacrs.timemanagment.core.entities.systementity.User;

import java.util.Date;

/**
 * The persistent class for the user_company database table.
 * 
 */
@Entity
@Table(name = "user_company")
@NamedQuery(name = "UserCompany.findAll", query = "SELECT u FROM UserCompany u")
public class UserCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserCompanyPK id;

	@Column(name = "default_overtime_fraction")
	private float defaultOvertimeFraction;

	@Column(name = "default_overtime_price")
	private float defaultOvertimePrice;

	@Column(name = "expected_hours", nullable = false)
	private float expectedHours;

	@Column(name = "hour_price", nullable = false)
	private float hourPrice;

	@Column(name = "is_full_time", nullable = false)
	private Boolean isFullTime;

	@Column(name = "is_overtime_per_day", nullable = false)
	private Boolean isOvertimePerDay;

	@Column(name = "join_date", nullable = false)
	private Date joinDate;

	@Column(nullable = false)
	private float salary;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private Company company;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	private User user;

	public UserCompany() {
	}

	public UserCompanyPK getId() {
		return this.id;
	}

	public void setId(UserCompanyPK id) {
		this.id = id;
	}

	public float getDefaultOvertimeFraction() {
		return this.defaultOvertimeFraction;
	}

	public void setDefaultOvertimeFraction(float defaultOvertimeFraction) {
		this.defaultOvertimeFraction = defaultOvertimeFraction;
	}

	public float getDefaultOvertimePrice() {
		return this.defaultOvertimePrice;
	}

	public void setDefaultOvertimePrice(float defaultOvertimePrice) {
		this.defaultOvertimePrice = defaultOvertimePrice;
	}

	public float getExpectedHours() {
		return this.expectedHours;
	}

	public void setExpectedHours(float expectedHours) {
		this.expectedHours = expectedHours;
	}

	public float getHourPrice() {
		return this.hourPrice;
	}

	public void setHourPrice(float hourPrice) {
		this.hourPrice = hourPrice;
	}

	public Boolean getIsFullTime() {
		return this.isFullTime;
	}

	public void setIsFullTime(Boolean isFullTime) {
		this.isFullTime = isFullTime;
	}

	public Boolean getIsOvertimePerDay() {
		return this.isOvertimePerDay;
	}

	public void setIsOvertimePerDay(Boolean isOvertimePerDay) {
		this.isOvertimePerDay = isOvertimePerDay;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}