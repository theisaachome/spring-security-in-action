package com.isaachome.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

	public CustomAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}
	

	public CustomAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}


	private static final long serialVersionUID = 1L; 

}
