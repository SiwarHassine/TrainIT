package com.c2s.dsif.controllers;

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
import com.c2s.dsif.service.UserService;

@RestController
@CrossOrigin(origins = "*")
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
		userService.saveOrUpdate(user);
		return user.getId();
	}

	@PutMapping("/updateUser")
	private User updateUser(@RequestBody User user) {
		userService.saveOrUpdate(user);
		return user;
	}

}
