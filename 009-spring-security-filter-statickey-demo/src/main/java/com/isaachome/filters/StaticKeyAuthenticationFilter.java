package com.isaachome.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticKeyAuthenticationFilter implements Filter {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Value("${authorization.key}")
	private String authorizationKey;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var httpRequest = (HttpServletRequest)request;
		var httpResponse= (HttpServletResponse)response;
		String authentication = httpRequest.getHeader("Authorization");
		logger.info(authentication);
		if(authorizationKey.equals(authentication)) {
			chain.doFilter(request, response);
		}else {
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
	}

}
