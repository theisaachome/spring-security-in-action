package com.isaachome.config.security.authentication.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.isaachome.config.security.authentication.CustomAuthentication;
import com.isaachome.config.security.manager.CustomAuthenticationManager;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter  extends OncePerRequestFilter{

	
	private final CustomAuthenticationManager customAuthenticationManager;
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		// 1. create an authentication object which is not yet authenticated
		String key = String.valueOf(request.getHeader("key"));
		var customAuth = new CustomAuthentication(key,false);
		
		
	    // 2. delegate the authentication object to the manager
		var auth = customAuthenticationManager.authenticate(customAuth);
	    // 3. get back the authentication from the manager
	    // 4. if the object is authenticated then send request to the next filter in the chain
		if(auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			filterChain.doFilter(request, response);
		}
	}

}
