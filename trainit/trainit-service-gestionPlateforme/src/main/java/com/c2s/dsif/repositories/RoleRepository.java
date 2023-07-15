package com.c2s.dsif.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.c2s.dsif.entities.UserRole;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

	@Query("SELECT r FROM UserRole r where r.roleName=:roleName")
	UserRole findByRoleName(String roleName);

}
