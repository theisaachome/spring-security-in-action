package com.isaachome.filters;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

@Component
public class CsrfTokenLogger implements Filter {

	private Logger log =  LoggerFactory.getLogger(CsrfTokenLogger.class);
	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		log.info("CSRF token : " + token.getToken());
		chain.doFilter(request, response);
	}

}
