package com.comp.cloudtech.controller;

import java.sql.Timestamp;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comp.cloudtech.service.DevIssueBookService;

@RestController
public class DevIssueBookController {

	Logger log = LoggerFactory.getLogger(DevIssueBookController.class);

	@Autowired
	DevIssueBookService service;

	@PostMapping("/issue")
	public JSONObject createIssue(@RequestBody String issueData) {

		log.info("Request to create dev issue at: " + new Timestamp(System.currentTimeMillis()));

		JSONObject issueJson = new JSONObject(issueData);

		service.saveIssue(issueJson);

		log.info("Created dev issue at: " + new Timestamp(System.currentTimeMillis()));

		return issueJson;
	}

	@CrossOrigin
	@GetMapping("/issue")
	public List<Object> getIssues() {

		List<Object> issues = service.listIssues();

		log.info("Returning issue list of size: " + issues.size() + " at: " + new Timestamp(System.currentTimeMillis()));

		return issues;
	}
}
