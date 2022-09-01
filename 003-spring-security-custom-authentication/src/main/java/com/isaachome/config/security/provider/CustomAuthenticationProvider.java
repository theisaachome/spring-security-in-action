package com.isaachome.config.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.isaachome.config.security.authentication.CustomAuthentication;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomAuthenticationProvider  implements AuthenticationProvider{
	
	// where authentication logic is implemented
	@Value("${auth.key}")
	private String key;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		CustomAuthentication ca = (CustomAuthentication)authentication;
		String headerKey = ca.getKey();
		log.info(headerKey);
		if(key.equals(headerKey)) {
			return new CustomAuthentication(null, true);
		}
		log.info(key);

	    throw new BadCredentialsException("Oh No!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.equals(authentication);
	}

}
