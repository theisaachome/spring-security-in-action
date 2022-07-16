package com.isaachome.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.isaachome.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	
	@Value("${key}")
	private String key;

	@Override
	public Authentication authenticate(Authentication authentication)  {
		String requestKey = authentication.getName();
		if(requestKey.equals(key)) {
			var a = new CustomAuthentication(null, null, null);
			return a;
		}else {
			throw new BadCredentialsException("Boo!");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.equals(authentication);
	}

}
