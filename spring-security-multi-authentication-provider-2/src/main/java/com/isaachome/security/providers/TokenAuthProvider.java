package com.isaachome.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.isaachome.security.authentication.TokenAuthentication;
import com.isaachome.security.managers.TokenManager;

@Component
public class TokenAuthProvider implements AuthenticationProvider {

	@Autowired
	private TokenManager tokenManager;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String token = authentication.getName();
		boolean exists = tokenManager.contains(token);
		if(exists) {
			return new TokenAuthentication(token, null,null);
		}
		throw new BadCredentialsException("Bad Token.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return TokenAuthentication.class.equals(authentication);
	}

}
