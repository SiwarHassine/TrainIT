package com.c2s.dsif.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.c2s.dsif.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u where u.Name=:Name and u.Password=:Password")
	public Optional<User> getUserByNameAndPassword(@Param("Name") String Name, @Param("Password") String Password);

	@Query("SELECT u FROM User u where u.Name=:Name")
	User findByUserName(@Param("Name") String Name);
	
	
	@Query("SELECT u FROM User u where u.NameManager=:NameManager")
	ArrayList<User> findByUserNameManager(@Param("NameManager") String NameManager);
	
	
}
