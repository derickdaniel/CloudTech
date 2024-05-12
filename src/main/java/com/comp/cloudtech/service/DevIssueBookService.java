package com.comp.cloudtech.service;

import java.util.List;

import org.json.JSONObject;

import com.comp.cloudtech.UserAccount;

public interface DevIssueBookService {
	
	List<Object> listIssues();
	
	void saveIssue(JSONObject issueJson);
	
	UserAccount updateIssue(JSONObject issueJson, Long id);
}
