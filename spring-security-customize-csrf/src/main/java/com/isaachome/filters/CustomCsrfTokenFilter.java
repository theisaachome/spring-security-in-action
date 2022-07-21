package com.isaachome.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.web.csrf.CsrfToken;

public class CustomCsrfTokenFilter  implements Filter{

	private Logger log = Logger.getLogger(CustomCsrfTokenFilter.class.getName());
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// get token
		CsrfToken token =(CsrfToken) request.getAttribute("_csrf");
		log.info("CSRF Token: " + token.getToken());
		chain.doFilter(request, response);
	}

}
