package com.isaachome.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.isaachome.security.authentication.UsernamePasswordAuthentication;
import com.isaachome.service.CustomUserDetailService;

@Component
public class UsernamePasswordAuthProvider 
implements AuthenticationProvider{

	@Autowired
	private CustomUserDetailService userDetailService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();

		System.out.println("UsernamePasswordAuthProvider");
		String password = (String) authentication.getCredentials();
	  UserDetails user=	userDetailService.loadUserByUsername(username);
	  if(passwordEncoder.matches(password, user.getPassword())) {
		  return new UsernamePasswordAuthentication(username, password,user.getAuthorities());
	  }
	  throw new BadCredentialsException(" Bad Credential Pls try again.");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthentication.class.equals(authentication);
	}

}
