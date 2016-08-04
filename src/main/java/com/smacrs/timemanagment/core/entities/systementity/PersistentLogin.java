package com.smacrs.timemanagment.core.entities.systementity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the persistent_logins database table.
 * 
 */
@Entity
@Table(name = "persistent_logins")
@NamedQuery(name = "PersistentLogin.findAll", query = "SELECT p FROM PersistentLogin p")
public class PersistentLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 64)
	private String series;

	@Column(name = "last_used", nullable = false)
	private Timestamp lastUsed;

	@Column(nullable = false, length = 64)
	private String token;

	@Column(nullable = false, length = 64)
	private String username;

	public PersistentLogin() {
	}

	public String getSeries() {
		return this.series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public Timestamp getLastUsed() {
		return this.lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}