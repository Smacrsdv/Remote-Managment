package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.SalaryDetailsHistoryPK;
import com.smacrs.timemanagment.core.entities.systementity.Company;
import com.smacrs.timemanagment.core.entities.systementity.User;

/**
 * The persistent class for the salary_details_history database table.
 * 
 */
@Entity
@Table(name = "salary_details_history")
@NamedQuery(name = "SalaryDetailsHistory.findAll", query = "SELECT s FROM SalaryDetailsHistory s")
public class SalaryDetailsHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalaryDetailsHistoryPK id;

	@Column(name = "achived_hours_num", nullable = false)
	private float achivedHoursNum;

	@Column(name = "expected_hours")
	private float expectedHours;

	@Column(name = "hour_price", nullable = false)
	private float hourPrice;

	@Column(name = "is_full_time", nullable = false)
	private Boolean isFullTime;

	@Column(name = "is_overtime_per_day", nullable = false)
	private Boolean isOvertimePerDay;

	@Column(name = "overtime_fraction")
	private float overtimeFraction;

	@Column(name = "overtime_price")
	private float overtimePrice;

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

	public SalaryDetailsHistory() {
	}

	public SalaryDetailsHistoryPK getId() {
		return this.id;
	}

	public void setId(SalaryDetailsHistoryPK id) {
		this.id = id;
	}

	public float getAchivedHoursNum() {
		return this.achivedHoursNum;
	}

	public void setAchivedHoursNum(float achivedHoursNum) {
		this.achivedHoursNum = achivedHoursNum;
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

	public float getOvertimeFraction() {
		return this.overtimeFraction;
	}

	public void setOvertimeFraction(float overtimeFraction) {
		this.overtimeFraction = overtimeFraction;
	}

	public float getOvertimePrice() {
		return this.overtimePrice;
	}

	public void setOvertimePrice(float overtimePrice) {
		this.overtimePrice = overtimePrice;
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