package com.isaachome.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.isaachome.config.authentications.ApiKeyAuthentication;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {

	private final String key;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		ApiKeyAuthentication auth = (ApiKeyAuthentication)authentication;
		if(key.equals(auth.getKey())) {
			auth.setAuthenticated(true);
			return auth;
		}
		throw new BadCredentialsException("Oh no key match pls try again.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return ApiKeyAuthentication.class.equals(authentication);
	}

}
