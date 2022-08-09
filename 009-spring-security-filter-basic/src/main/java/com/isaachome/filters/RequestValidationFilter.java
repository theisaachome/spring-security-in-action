package com.isaachome.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestValidationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		var httpRequest =(HttpServletRequest)request;
		var httpResponse = (HttpServletResponse) response;
		String requestId = httpRequest.getHeader("Request-id");
		if(requestId==null || requestId.isBlank()) {
			httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return ;
		}
		chain.doFilter(request, response);
	}

}
