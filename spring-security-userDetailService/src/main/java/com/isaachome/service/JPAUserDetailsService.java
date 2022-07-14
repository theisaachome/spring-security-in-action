package com.isaachome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isaachome.entity.User;
import com.isaachome.repo.UserRepo;

public class JPAUserDetailsService implements UserDetailsService {

	@Autowired
	private  UserRepo userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found with " + username));
		System.out.println(user.getUsername());
		return new SecurityUser(user);
	}

}
