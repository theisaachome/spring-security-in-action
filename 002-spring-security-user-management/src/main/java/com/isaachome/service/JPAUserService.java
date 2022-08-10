package com.isaachome.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isaachome.repo.UserRepo;
import com.isaachome.security.SecurityUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JPAUserService implements UserDetailsService {

	private final UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username)  {
		
		var user = userRepo.findUserByUsername(username);
		System.out.println(user.get().getUsername());
		return user.map(SecurityUser::new).orElseThrow(
				()-> 
		new UsernameNotFoundException("Username not found : " + user));
	}

}
