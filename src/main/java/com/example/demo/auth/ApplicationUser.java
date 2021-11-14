package com.example.demo.auth;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUser implements UserDetails {
	
	private final String username;
	private final String password;
	private final Set<? extends GrantedAuthority> grantedAuthorities;
	private final Boolean isAccountNonExpired;
	private final Boolean isAccountNonLocked;
	private final Boolean isCredentialsNonExpired;
	private final Boolean isEnabled;
	
	public ApplicationUser(String username,
						   String password, 
						   Set<? extends GrantedAuthority> authorities,
						   Boolean isAccountNonExpired, 
						   Boolean isAccountNonLocked, 
						   Boolean isCredentialsNonExpired,
						   Boolean isEnabled) {
		this.username = username;
		this.password = password;
		this.grantedAuthorities = authorities;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

}
