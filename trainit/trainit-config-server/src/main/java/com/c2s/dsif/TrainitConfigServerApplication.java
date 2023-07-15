package com.c2s.dsif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TrainitConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainitConfigServerApplication.class, args);
	}
	
	

}
