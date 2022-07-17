package com.isaachome.security.providers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.isaachome.repo.OTPRepo;
import com.isaachome.security.authentication.OtpAuthentication;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private OTPRepo otpRepo;
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String otp = (String)authentication.getCredentials();

		System.out.println("OtpAuthenticationProvider()");
		
		var o = otpRepo.findOTPByUsername(username);
		
		if(o.isPresent()) {
			return new OtpAuthentication(username, otp,List.of(()->"read"));
		}

		throw new BadCredentialsException("No Otp in the credential");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return OtpAuthentication.class.equals(authentication);
	}

	
}
