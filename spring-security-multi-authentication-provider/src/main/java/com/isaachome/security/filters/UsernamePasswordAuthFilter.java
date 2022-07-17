package com.isaachome.security.filters;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.isaachome.entity.Otp;
import com.isaachome.repo.OTPRepo;
import com.isaachome.security.authentication.OTPAuthentication;
import com.isaachome.security.authentication.UsernamePasswordAuthentication;

@Component
public class UsernamePasswordAuthFilter  extends OncePerRequestFilter{
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private OTPRepo otpRepo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// step - 1 => username and password
		// step -2 => username and opt
		
		String username = request.getHeader("username");
		
		String password = request.getHeader("password");
		String otp = request.getHeader("otp");
		String code = String.valueOf(new Random().nextInt(9999)+1000 );
		
		if(otp == null) {
			// Step 1
			Authentication a = new UsernamePasswordAuthentication(username, password);
			a =authenticationManager.authenticate(a);
//			SecurityContextHolder.getContext().setAuthentication(a);
			// we generate otp
			Otp otpEntity = new Otp();
			otpEntity.setUsername(username);
			otpEntity.setOtp(code);
			otpRepo.save(otpEntity);
			
		}else {
			// Step 2
			Authentication b = new OTPAuthentication(username	, otp);
			authenticationManager.authenticate(b);
//			SecurityContextHolder.getContext().setAuthentication(b);
			// we issue token
			response.setHeader("Authorization", UUID.randomUUID().toString());
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return !request.getServletPath().equals("/login");
	}

	
}
