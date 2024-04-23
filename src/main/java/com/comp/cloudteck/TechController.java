package com.comp.cloudteck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechController {
	
	@PostMapping("/")
	public String process() {
		return "result";
	}

	@GetMapping("/test")
	public String sendGreetings() {
		return "test";
	}
}
