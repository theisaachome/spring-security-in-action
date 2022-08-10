package com.isaachome.security.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.isaachome.security.authentication.CustomAuthentication;
import com.isaachome.security.managers.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

	private final CustomAuthenticationManager manager;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 1. create an authentication object which is not yet authenticated
		// 2. delegate the authentication object to the manager
		// 3. get back the authentication from the manager
		// 4. if the object is authenticated then send request to the next filter in the
		// chain

		String key = String.valueOf(request.getHeader("key"));
		CustomAuthentication ca = new CustomAuthentication(false, key);

		var auth = manager.authenticate(ca);
		if (auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
			filterChain.doFilter(request, response);
		}
	}

}
