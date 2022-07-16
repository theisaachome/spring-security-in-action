package com.isaachome.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.isaachome.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationFilter implements Filter {

	
	@Autowired
	private AuthenticationManager manager;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var httpRequest = (HttpServletRequest)request;
		var httpResponse = (HttpServletResponse)response;
		
		var authorization = httpRequest.getHeader("Authorization");
		var auth= new CustomAuthentication(authorization, null);
		 
		try {

			 Authentication result =	manager.authenticate(auth);
			 if(result.isAuthenticated() ) {
				 SecurityContextHolder.getContext().setAuthentication(result);
				 chain.doFilter(request, response);
			 }
		} catch (AuthenticationException e) {
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		
	}

}
