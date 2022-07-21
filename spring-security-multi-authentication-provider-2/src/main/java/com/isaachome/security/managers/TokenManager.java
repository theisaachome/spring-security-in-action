package com.isaachome.security.managers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {

	private Set<String> tokens = new HashSet<>();
	
	
	public void add(String token) {
		tokens.add(token);
	}
	
	public boolean contains(String token) {
		return tokens.contains(token);
	}
}
