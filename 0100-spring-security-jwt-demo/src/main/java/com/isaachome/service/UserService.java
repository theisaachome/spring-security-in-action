package com.isaachome.service;

import java.util.List;

import com.isaachome.domain.Role;
import com.isaachome.domain.User;


public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
}
