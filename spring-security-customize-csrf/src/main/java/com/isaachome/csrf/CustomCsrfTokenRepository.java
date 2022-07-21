package com.isaachome.csrf;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import com.isaachome.entity.Token;
import com.isaachome.repo.JpaTokenRepo;

public class CustomCsrfTokenRepository implements CsrfTokenRepository{

	@Autowired
	private JpaTokenRepo jpaTokenRepo;
	@Override
	public CsrfToken generateToken(HttpServletRequest request) {
		String uuid= UUID.randomUUID().toString();
		System.out.println("Generated Token : " + uuid);
		return new DefaultCsrfToken("X-CSRF-TOKEN", "-csrf", uuid);
	}

	@Override
	public void saveToken(
			CsrfToken csrfToken, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		String identifier = request.getHeader("X-IDENTIFIER");
		if(identifier.isEmpty()) {
			throw new BadCredentialsException("Invalid IDENTIFIER");

		}
		Optional<Token> existingToken = jpaTokenRepo.findTokenByIdentifier(identifier);
		
		if(existingToken.isPresent()) {
			Token token = existingToken.get();
			token.setToken(csrfToken.getToken());
		}else {
			Token token = new Token();
			token.setCreatedAt(LocalDateTime.now());
			token.setIdentifier(identifier);
			token.setToken(csrfToken.getToken());
			jpaTokenRepo.save(token);
		}
		
	}

	@Override
	public CsrfToken loadToken(HttpServletRequest request) {
		String identifier = request.getHeader("X-IDENTIFIER");
		Optional<Token> token = jpaTokenRepo.findTokenByIdentifier(identifier);
		if(token.isPresent()) {
			return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.get().getToken());
		}
		return null;
	}

}
