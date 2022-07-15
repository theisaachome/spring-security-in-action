package com.isaachome.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		// here you implement the authentication logic
		// if the request is authenticated you should return here
		// an fully authenticated Authentication instance
		// if the authentication is not authenticated you should throw AuthenticationException
		// the authentication isn't supported by this API -> return null
		
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
	  UserDetails user=	userDetailsService.loadUserByUsername(username);
		
		if(user !=null) {
			if(passwordEncoder.matches(password, user.getPassword())) {
				var a = new UsernamePasswordAuthenticationToken(username, password,user.getAuthorities());
				return a;
			}
		}
		throw new BadCredentialsException("Invalid Credential!.");
	}

	@Override
	public boolean supports(Class<?> authType) { // type of Authentication
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.equals(authType);
	}

}
