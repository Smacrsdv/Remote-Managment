package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private Boolean active;

	@Column(length=500)
	private String address;

	@Column(length=150)
	private String email;

	@Column(name="is_company_non_expired", nullable=false)
	private Boolean isCompanyNonExpired;

	@Column(name="is_company_non_locked", nullable=false)
	private Boolean isCompanyNonLocked;

	@Column(nullable=false, length=50)
	private String name;

	@Column(nullable=false, length=50)
	private String nickname;

	//bi-directional one-to-one association to CompanyInfo
	@OneToOne(mappedBy="company")
	private CompanyInfo companyInfo;

	public Company() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsCompanyNonExpired() {
		return this.isCompanyNonExpired;
	}

	public void setIsCompanyNonExpired(Boolean isCompanyNonExpired) {
		this.isCompanyNonExpired = isCompanyNonExpired;
	}

	public Boolean getIsCompanyNonLocked() {
		return this.isCompanyNonLocked;
	}

	public void setIsCompanyNonLocked(Boolean isCompanyNonLocked) {
		this.isCompanyNonLocked = isCompanyNonLocked;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public CompanyInfo getCompanyInfo() {
		return this.companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

}