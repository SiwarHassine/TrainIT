package com.c2s.dsif;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("COLLAB")
public interface CollabClient {
	@GetMapping("/greeting")
	String greeting();
	
	@GetMapping("/port")
	int findPort();
}
