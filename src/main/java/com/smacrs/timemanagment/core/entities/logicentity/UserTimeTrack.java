package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.systementity.Company;
import com.smacrs.timemanagment.core.entities.systementity.User;

import java.util.Date;

/**
 * The persistent class for the user_time_track database table.
 * 
 */
@Entity
@Table(name = "user_time_track")
@NamedQuery(name = "UserTimeTrack.findAllByUserANDCompany", query = "SELECT u FROM UserTimeTrack u WHERE u.user.id = :USERID and u.company.id = :COMPANYID")
public class UserTimeTrack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private String id;

	@Column(nullable = false)
	private Date date;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "start_time", nullable = false)
	private Date startTime;

	@Column(name = "total_minutes", nullable = false)
	private int totalMinutes;

	// uni-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;

	// uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public UserTimeTrack() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getTotalMinutes() {
		return this.totalMinutes;
	}

	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
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