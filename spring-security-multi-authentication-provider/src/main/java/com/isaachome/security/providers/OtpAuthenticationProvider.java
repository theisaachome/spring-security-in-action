package com.isaachome.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.isaachome.repo.OTPRepo;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private OTPRepo otpRepo;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String otp = (String)authentication.getCredentials();
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return OtpAuthenticationProvider.class.equals(authentication);
	}

	
}
