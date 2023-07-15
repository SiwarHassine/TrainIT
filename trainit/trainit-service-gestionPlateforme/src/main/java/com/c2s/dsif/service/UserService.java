package com.c2s.dsif.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.c2s.dsif.entities.User;
import com.c2s.dsif.entities.UserRole;
import com.c2s.dsif.repositories.RoleRepository;
import com.c2s.dsif.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository userRoleRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	public void AddNewUser(User user) {
		String pw = user.getPassword();
		user.setPassword(pw);
		userRepository.save(user);
	}

	public void UpdateUser(User user) {
		userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public Long loginValidation(String nameUser, String password) {
		Long res = 0L;
		Optional<User> user = userRepository.getUserByNameAndPassword(nameUser, password);
		if ((user.isPresent())) {
			res = user.get().getId();
		} else {
			res = -1L;
		}
		return res;
	}

	public UserRole AddNewRole(UserRole role) {
		return userRoleRepository.save(role);
	}

	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUserName(username);
		UserRole role = userRoleRepository.findByRoleName(roleName);
		user.setUserRoles(roleName);
	}

	public User loadUserByName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public List<User> getAllUsersByManager(String name){
		List<User> users = new ArrayList<User>();
		users=userRepository.findByUserNameManager(name);
		return users;
	}

	public String getRoleUser(String name) {
		User user=userRepository.findByUserName(name);
		return user.getUserRoles();
	}
	
	public Long getIdUser(String name) {
		User user=userRepository.findByUserName(name);
		return user.getId()	;
		}
	

}
