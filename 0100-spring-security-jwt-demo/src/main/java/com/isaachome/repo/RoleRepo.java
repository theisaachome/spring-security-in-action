package com.isaachome.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isaachome.domain.Role;

public interface RoleRepo  extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
