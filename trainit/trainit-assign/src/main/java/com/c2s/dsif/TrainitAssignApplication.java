package com.c2s.dsif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrainitAssignApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainitAssignApplication.class, args);
	}

}
