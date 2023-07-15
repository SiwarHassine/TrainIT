package com.c2s.dsif.trainitregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class TrainitRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainitRegistryApplication.class, args);
	}
	
	
	

}
