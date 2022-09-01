package com.isaachome.config.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.isaachome.config.security.provider.CustomAuthenticationProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager  implements AuthenticationManager{

	private final CustomAuthenticationProvider provider;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(provider.supports(authentication.getClass())) {
			return provider.authenticate(authentication);
		}
		throw new BadCredentialsException("Bad Auth");
	}

}
