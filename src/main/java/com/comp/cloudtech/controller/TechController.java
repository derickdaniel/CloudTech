package com.comp.cloudtech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TechController {
	
	@PostMapping("/")
	public String process() {
		return "Cloud-Tech Home";
	}

	@GetMapping("/ping")
	public String sendGreetings() {
		return "pinged!";
	}
}
