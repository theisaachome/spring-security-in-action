package com.isaachome.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.isaachome.security.authentication.OTPAuthentication;
import com.isaachome.security.authentication.UsernamePasswordAuthentication;

@Component
public class UsernamePasswordAuthFilter  extends OncePerRequestFilter{
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// step - 1 => username and password
		// step -2 => username and opt
		
		String username = request.getHeader("username");
		
		String password = request.getHeader("password");
		String otp = request.getHeader("otp");
		
		if(otp != null) {
			// Step 1
			Authentication a = new UsernamePasswordAuthentication(username, password);
			a =authenticationManager.authenticate(a);
			SecurityContextHolder.getContext().setAuthentication(a);
		}else {
			// Step 2
			Authentication b = new OTPAuthentication(username	, otp);
			authenticationManager.authenticate(b);
			SecurityContextHolder.getContext().setAuthentication(b);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return !request.getServletPath().equals("/login");
	}

	
}
