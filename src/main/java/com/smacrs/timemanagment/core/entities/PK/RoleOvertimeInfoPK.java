package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the role_overtime_info database table.
 * 
 */
@Embeddable
public class RoleOvertimeInfoPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "company_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int companyId;

	@Column(name = "role_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int roleId;

	public RoleOvertimeInfoPK() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RoleOvertimeInfoPK)) {
			return false;
		}
		RoleOvertimeInfoPK castOther = (RoleOvertimeInfoPK) other;
		return (this.companyId == castOther.companyId) && (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyId;
		hash = hash * prime + this.roleId;

		return hash;
	}
}