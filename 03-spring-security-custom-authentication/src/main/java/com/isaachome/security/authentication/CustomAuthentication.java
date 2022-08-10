package com.isaachome.security.authentication;

import java.util.Collection;

import javax.security.auth.Subject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomAuthentication implements Authentication {

	private static final long serialVersionUID = 1L;
	private final boolean authenticate;
	private final String key;

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return authenticate;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean implies(Subject subject) {
		// TODO Auto-generated method stub
		return Authentication.super.implies(subject);
	}

}
