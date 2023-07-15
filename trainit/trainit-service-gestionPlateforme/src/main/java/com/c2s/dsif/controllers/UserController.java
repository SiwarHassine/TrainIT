package com.c2s.dsif.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c2s.dsif.entities.User;
import com.c2s.dsif.entities.UserRole;
import com.c2s.dsif.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	private UserService userService;

	
	
	@GetMapping("/getAllusers")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getUser/{userid}")
	private User getUser(@PathVariable("userid") Long userid) {
		return userService.getUserById(userid);
	}

	@DeleteMapping("/deleteUser/{userid}")
	private void deleteUser(@PathVariable("userid") Long userid) {
		userService.delete(userid);
	}

	@PostMapping("/saveUser")
	private Long saveUser(@RequestBody User user) {
		userService.AddNewUser(user);
		return user.getId();
	}

	@PutMapping("/updateUser")
	private User updateUser(@RequestBody User user) {
		userService.UpdateUser(user);
		return user;
	}

	@GetMapping("verfUser/{userName}/{password}")
	public Long loginValidation(@PathVariable("userName") String userName, @PathVariable("password") String password) {
		Long res = userService.loginValidation(userName, password);
		return res;
	}

	@PostMapping("/saveRole")
	public UserRole saveRole(@RequestBody UserRole Role) {
		return userService.AddNewRole(Role);
	}

	@PostMapping("/addRoleToUser")
	public void addRoleToUser(@RequestBody String name, @RequestBody String role) {
		userService.addRoleToUser(name, role);
	}
	
	@GetMapping("/getAllusersByManager/{managerName}")
	private List<User> getAllUsersByManager(@PathVariable("managerName") String managerName) {
		return userService.getAllUsersByManager(managerName);
	}
	
	@GetMapping("/getUserRole/{name}")
	private List<String> getUserRole(@PathVariable("name") String name) {
		 List<String> response = new ArrayList();
		String role= userService.getRoleUser(name);
		 response.add(role);
		  return response;
	}
	

	@GetMapping("/getUserId/{name}")
	private List<Long> getUserId(@PathVariable("name") String name) {
		 List<Long> response = new ArrayList();
		Long Id= userService.getIdUser(name);
		 response.add(Id);
		  return response;
	}
}
