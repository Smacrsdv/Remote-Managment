package com.smacrs.timemanagment.core.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smacrs.timemanagment.core.dao.AccountRepo;
import com.smacrs.timemanagment.core.entities.systementity.Account;

/**
 * Created by Chris on 10/19/14.
 */
public class AccountUserDetails implements UserDetails {
	private final Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Autowired
	AccountRepo accountRepo;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// GrantedAuthority authority = new GrantedAuthority() {
		// @Override
		// public String getAuthority() {
		// return "ROLE_ADMIN";
		// }
		// };

		// GrantedAuthority user = new GrantedAuthority() {
		// @Override
		// public String getAuthority() {
		// return "ROLE_USER";
		// }
		// };
//		account.setAuthorities(accountRepo.findAccountByName(account.getUsername()).getAuthorities());
		ArrayList<GrantedAuthority> authorities= new ArrayList<>();
		for (int i = 0; i < account.getAuthorities().size(); i++) {
			String authority=account.getAuthorities().get(i).getName();
			authorities.add(new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return authority;
				}
			});
		}
		

		// GrantedAuthority user_nickname = new GrantedAuthority() {
		// @Override
		// public String getAuthority() {
		// return "ROLE_USER_#nickname";
		// }
		// };

		//ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// authorities.add(authority);
		// authorities.add(user);
		//authorities.add(user_smacrs);
		// authorities.add(user_nickname);

		return authorities;
//		return null;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return account.getIsAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return account.getIsAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return account.getIsCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return account.getIsEnabled();
	}
}
