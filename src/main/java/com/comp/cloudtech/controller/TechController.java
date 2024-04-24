package com.comp.cloudtech.controller;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.cloudtech.util.EnvUtil;

@RestController
public class TechController {

	Logger log = LoggerFactory.getLogger(TechController.class);

	@Autowired
	private EnvUtil envUtil;

	@GetMapping("/env")
	public Map<String, Object> process() throws UnknownHostException {

		log.info("Fetching env details at: " + new Timestamp(System.currentTimeMillis()));

		Map<String, Object> map = envUtil.envDetailsMap();

		log.info("Env details finished at: " + new Timestamp(System.currentTimeMillis()));

		return map;
	}

	@GetMapping("/ping")
	public String sendGreetings() {
		return "pinged!";
	}
	
	@GetMapping("/jerry")
	public String jerry() {
		return "Hello Jerry, Tapte ki tu :).....";
	}
}
