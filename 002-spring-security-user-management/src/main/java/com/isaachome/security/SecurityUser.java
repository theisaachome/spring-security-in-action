package com.isaachome.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.isaachome.entity.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUser  implements UserDetails{

	private static final long serialVersionUID = 1L;
	private final User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  return user.getAuthorities()
			        .stream()
			        .map(SecurityAuthority::new)
			        .collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
