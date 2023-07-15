package com.c2s.dsif.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollabController {
	@GetMapping("/welcomeCollab")
	public String hello() {
		return " i'm Collab";
	}
	@GetMapping("/greeting")
	public String greeting() {
		return "Tu à 42 collaborateurs dans l'équipe";
	}
	
	  @Value("${server.port}")
	  private int port;

	@GetMapping("/port")
		public int findPort() {
		  return port;
			
		}
		
	
	
	
}
