package com.smacrs.timemanagment.core.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smacrs.timemanagment.core.entities.Account;

/**
 * Created by Chris on 10/19/14.
 */
public class AccountUserDetails implements UserDetails {
	private final Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		GrantedAuthority authority = new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				return "ROLE_ADMIN";
//			}
//		};

		GrantedAuthority user = new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return "ROLE_USER";
			}
		};

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//authorities.add(authority);
		authorities.add(user);
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
