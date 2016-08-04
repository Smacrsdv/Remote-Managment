package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.RoleOvertimeInfoPK;


/**
 * The persistent class for the role_overtime_info database table.
 * 
 */
@Entity
@Table(name="role_overtime_info")
@NamedQuery(name="RoleOvertimeInfo.findAll", query="SELECT r FROM RoleOvertimeInfo r")
public class RoleOvertimeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RoleOvertimeInfoPK id;

	@Column(name="default_overtime_fraction")
	private float defaultOvertimeFraction;

	@Column(name="default_overtime_price")
	private float defaultOvertimePrice;

	@Column(name="is_overtime_per_day", nullable=false)
	private Boolean isOvertimePerDay;

	public RoleOvertimeInfo() {
	}

	public RoleOvertimeInfoPK getId() {
		return this.id;
	}

	public void setId(RoleOvertimeInfoPK id) {
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

	public Boolean getIsOvertimePerDay() {
		return this.isOvertimePerDay;
	}

	public void setIsOvertimePerDay(Boolean isOvertimePerDay) {
		this.isOvertimePerDay = isOvertimePerDay;
	}

}