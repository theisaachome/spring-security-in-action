package com.isaachome.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationLoggingFilter implements Filter {

	private static Logger log =
			Logger.getLogger(AuthenticationLoggingFilter.class.getName());
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var httpRequest = (HttpServletRequest) request;
		String requestId = httpRequest.getHeader("Request-Id");
		log.info("Successfully Authenticated with id " + requestId);
		chain.doFilter(request, response);
	}

}
