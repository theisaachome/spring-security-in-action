package com.isaachome.security.authentication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class TokenAuthentication extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;

	public TokenAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}

	public TokenAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}

	
}
