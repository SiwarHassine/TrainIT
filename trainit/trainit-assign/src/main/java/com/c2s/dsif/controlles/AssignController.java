package com.c2s.dsif.controlles;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.c2s.dsif.CollabClient;
@RestController
public class AssignController {
	
	@Autowired
	private CollabClient CollabClient;
	
	 
	@GetMapping("/welcome")
	public String welcome() {	
		return " Welcome to assignment";
	}
	
	@GetMapping("/assign")
	public String assign() {
	String r=CollabClient.greeting();
	return r;
}
	
	@GetMapping("/findport")
	public int findPort() {
		return CollabClient.findPort();
	}
}
