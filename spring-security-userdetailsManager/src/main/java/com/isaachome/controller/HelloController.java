package com.isaachome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.isaachome.model.User;

@RestController
public class HelloController {
	
	@Autowired
	private JdbcUserDetailsManager userDetailsManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDetailsManager.createUser(user);
	}
}
