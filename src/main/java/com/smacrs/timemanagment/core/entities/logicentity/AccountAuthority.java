package com.smacrs.timemanagment.core.entities.logicentity;

import java.io.Serializable;
import javax.persistence.*;

import com.smacrs.timemanagment.core.entities.PK.AccountAuthorityPK;
import com.smacrs.timemanagment.core.entities.lut.LutAuthority;
import com.smacrs.timemanagment.core.entities.systementity.Account;
import com.smacrs.timemanagment.core.entities.systementity.Company;

import java.util.Date;

/**
 * The persistent class for the account_authority database table.
 * 
 */
@Entity
@Table(name = "account_authority")
@NamedQuery(name = "AccountAuthority.findAll", query = "SELECT a FROM AccountAuthority a")
public class AccountAuthority implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccountAuthorityPK id;

	@Column(name = "denied_at")
	private Date deniedAt;

	@Column(name = "grant_at", nullable = false)
	private Date grantAt;

	@Column(name = "is_granted", nullable = false)
	private Boolean isGranted;

	@ManyToOne
	@JoinColumn(name = "account_id", nullable = false, insertable = false, updatable = false)
	private Account account;

	@ManyToOne
	@JoinColumn(name = "grant_by", nullable = false)
	private Account grantedBy;

	@ManyToOne
	@JoinColumn(name = "denied_by")
	private Account deniedBy;

	@ManyToOne
	@JoinColumn(name = "authority_id", nullable = false, insertable = false, updatable = false)
	private LutAuthority lutAuthority;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private Company company;

	public AccountAuthority() {
	}

	public AccountAuthorityPK getId() {
		return this.id;
	}

	public void setId(AccountAuthorityPK id) {
		this.id = id;
	}

	public Date getDeniedAt() {
		return this.deniedAt;
	}

	public void setDeniedAt(Date deniedAt) {
		this.deniedAt = deniedAt;
	}

	public Date getGrantAt() {
		return this.grantAt;
	}

	public void setGrantAt(Date grantAt) {
		this.grantAt = grantAt;
	}

	public Boolean getIsGranted() {
		return this.isGranted;
	}

	public void setIsGranted(Boolean isGranted) {
		this.isGranted = isGranted;
	}

	public Account getAccount1() {
		return this.account;
	}

	public void setAccount1(Account account1) {
		this.account = account1;
	}

	public Account getAccount2() {
		return this.grantedBy;
	}

	public void setAccount2(Account account2) {
		this.grantedBy = account2;
	}

	public Account getAccount3() {
		return this.deniedBy;
	}

	public void setAccount3(Account account3) {
		this.deniedBy = account3;
	}

	public LutAuthority getLutAuthority() {
		return this.lutAuthority;
	}

	public void setLutAuthority(LutAuthority lutAuthority) {
		this.lutAuthority = lutAuthority;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}