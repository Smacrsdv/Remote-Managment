package com.smacrs.timemanagment.core.entities.PK;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the account_authority database table.
 * 
 */
@Embeddable
public class AccountAuthorityPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "account_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int accountId;

	@Column(name = "authority_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int authorityId;

	@Column(name = "company_id", insertable = false, updatable = false, unique = true, nullable = false)
	private int companyId;

	public AccountAuthorityPK() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccountAuthorityPK)) {
			return false;
		}
		AccountAuthorityPK castOther = (AccountAuthorityPK) other;
		return (this.accountId == castOther.accountId) && (this.authorityId == castOther.authorityId)
				&& (this.companyId == castOther.companyId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.accountId;
		hash = hash * prime + this.authorityId;
		hash = hash * prime + this.companyId;

		return hash;
	}
}