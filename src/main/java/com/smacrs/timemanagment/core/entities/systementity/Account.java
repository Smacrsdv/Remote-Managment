package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@Table(name = "account")
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 150)
	private String email;

	@Column(name = "is_account_non_expired", nullable = false)
	private boolean isAccountNonExpired;

	@Column(name = "is_account_non_locked", nullable = false)
	private boolean isAccountNonLocked;

	@Column(name = "is_credentials_non_expired", nullable = false)
	private boolean isCredentialsNonExpired;

	@Column(name = "is_enabled", nullable = false)
	private boolean isEnabled;
//
//	@Column(length = 255)
//	private String name;

	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50)
	private String username;

	public Account() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	public void setIsAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public boolean getIsAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	public void setIsAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public boolean getIsCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	public void setIsCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

//	public String getName() {
//		return this.name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}