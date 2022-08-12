package com.isaachome.config.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.isaachome.config.ApiKeyProvider;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CustomAuthenticationManager  implements AuthenticationManager{

	private final String key;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var provider = new ApiKeyProvider(key);
		if(provider.supports(authentication.getClass())) {
			return provider.authenticate(authentication);
		}
		return authentication;
	}

}
