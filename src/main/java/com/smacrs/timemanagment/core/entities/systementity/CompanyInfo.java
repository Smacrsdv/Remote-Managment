package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the company_info database table.
 * 
 */
@Entity
@Table(name="company_info")
@NamedQuery(name="CompanyInfo.findAll", query="SELECT c FROM CompanyInfo c")
public class CompanyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id", unique=true, nullable=false)
	private int companyId;

	@Column(name="break_time", nullable=false)
	private int breakTime;

	@Column(name="default_overtime_fraction")
	private float defaultOvertimeFraction;

	@Column(name="default_overtime_price")
	private float defaultOvertimePrice;

	@Column(name="e_time", nullable=false)
	private Date eTime;

	@Column(name="expected_hours", nullable=false)
	private int expectedHours;

	private Boolean friday;

	@Column(name="is_break_time_work_time", nullable=false)
	private Boolean isBreakTimeWorkTime;

	@Column(name="is_cpm", nullable=false)
	private Boolean isCpm;

	@Column(name="is_overlab_happen", nullable=false)
	private Boolean isOverlabHappen;

	@Column(name="is_overtime_included", nullable=false)
	private Boolean isOvertimeIncluded;

	@Column(name="is_overtime_per_day", nullable=false)
	private Boolean isOvertimePerDay;

	@Column(name="is_vacancy_included", nullable=false)
	private Boolean isVacancyIncluded;

	@Column(name="is_weekend_included", nullable=false)
	private Boolean isWeekendIncluded;

	private Boolean monday;

	@Column(name="s_time", nullable=false)
	private Date sTime;

	@Column(name="salary_day", nullable=false)
	private Date salaryDay;

	private Boolean saturday;

	private Boolean sunday;

	private Boolean thursday;

	private Boolean tuesday;

	private Boolean wednesday;

	@Column(name="work_time", nullable=false)
	private int workTime;

	//bi-directional one-to-one association to Company
	@OneToOne
	@JoinColumn(name="company_id", nullable=false, insertable=false, updatable=false)
	private Company company;

	public CompanyInfo() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getBreakTime() {
		return this.breakTime;
	}

	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
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

	public Date getETime() {
		return this.eTime;
	}

	public void setETime(Date eTime) {
		this.eTime = eTime;
	}

	public int getExpectedHours() {
		return this.expectedHours;
	}

	public void setExpectedHours(int expectedHours) {
		this.expectedHours = expectedHours;
	}

	public Boolean getFriday() {
		return this.friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getIsBreakTimeWorkTime() {
		return this.isBreakTimeWorkTime;
	}

	public void setIsBreakTimeWorkTime(Boolean isBreakTimeWorkTime) {
		this.isBreakTimeWorkTime = isBreakTimeWorkTime;
	}

	public Boolean getIsCpm() {
		return this.isCpm;
	}

	public void setIsCpm(Boolean isCpm) {
		this.isCpm = isCpm;
	}

	public Boolean getIsOverlabHappen() {
		return this.isOverlabHappen;
	}

	public void setIsOverlabHappen(Boolean isOverlabHappen) {
		this.isOverlabHappen = isOverlabHappen;
	}

	public Boolean getIsOvertimeIncluded() {
		return this.isOvertimeIncluded;
	}

	public void setIsOvertimeIncluded(Boolean isOvertimeIncluded) {
		this.isOvertimeIncluded = isOvertimeIncluded;
	}

	public Boolean getIsOvertimePerDay() {
		return this.isOvertimePerDay;
	}

	public void setIsOvertimePerDay(Boolean isOvertimePerDay) {
		this.isOvertimePerDay = isOvertimePerDay;
	}

	public Boolean getIsVacancyIncluded() {
		return this.isVacancyIncluded;
	}

	public void setIsVacancyIncluded(Boolean isVacancyIncluded) {
		this.isVacancyIncluded = isVacancyIncluded;
	}

	public Boolean getIsWeekendIncluded() {
		return this.isWeekendIncluded;
	}

	public void setIsWeekendIncluded(Boolean isWeekendIncluded) {
		this.isWeekendIncluded = isWeekendIncluded;
	}

	public Boolean getMonday() {
		return this.monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Date getSTime() {
		return this.sTime;
	}

	public void setSTime(Date sTime) {
		this.sTime = sTime;
	}

	public Date getSalaryDay() {
		return this.salaryDay;
	}

	public void setSalaryDay(Date salaryDay) {
		this.salaryDay = salaryDay;
	}

	public Boolean getSaturday() {
		return this.saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return this.sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Boolean getThursday() {
		return this.thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getTuesday() {
		return this.tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return this.wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public int getWorkTime() {
		return this.workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}