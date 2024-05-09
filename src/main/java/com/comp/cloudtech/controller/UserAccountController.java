package com.comp.cloudtech.controller;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comp.cloudtech.UserAccount;
import com.comp.cloudtech.service.UserAccountService;

@RestController
public class UserAccountController {

	@Autowired
	UserAccountService userService;

	Logger log = LoggerFactory.getLogger(UserAccountController.class);

	@PostMapping("/users")
	public UserAccount createUserAccount(@RequestBody UserAccount userAccount) {

		log.info("Request to create user account at: " + new Timestamp(System.currentTimeMillis()));

		userService.saveUser(userAccount);

		log.info("Created user account at: " + new Timestamp(System.currentTimeMillis()));

		return userAccount;
	}

	@GetMapping("/users")
	public Map<Long, UserAccount> userList() throws UnknownHostException {

		log.info("Fetching user list at: " + new Timestamp(System.currentTimeMillis()));

		List<UserAccount> users = userService.listUsers();

		Map<Long, UserAccount> map = new HashMap<Long, UserAccount>();
		if (!users.isEmpty()) {
			map = users.stream().collect(Collectors.toMap(u -> u.id, u -> u));
		}

		log.info("user list fetching finished at: " + new Timestamp(System.currentTimeMillis()));

		return map;
	}
}
